package me.dienes.abseil.mixin;

import me.dienes.abseil.ClimbingRopeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.TripwireHookBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    @Shadow
    private Optional<BlockPos> climbingPos;

    // Allow climbing through TripwireHookBlock, if a ClimbingRopeBlock is underneath
    @Inject(method="isClimbing()Z", at=@At("TAIL"), cancellable = true)
    public void isClimbingOnTripwireHookAboveRope(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = ((LivingEntity)(Object)this);

        BlockPos blockPos = self.getBlockPos();
        BlockState blockState = self.getBlockStateAtPos();

        boolean onTripwireHookBlock = blockState.getBlock() instanceof TripwireHookBlock;
        boolean ropeBelow = self.getWorld().getBlockState(blockPos.down()).getBlock() instanceof ClimbingRopeBlock;

        if (onTripwireHookBlock && ropeBelow) {
            climbingPos = Optional.of(blockPos);
            cir.setReturnValue(true);
        }
    }
}
