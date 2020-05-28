package j0sh.javadungeons.blocks;

import j0sh.javadungeons.JavaDungeons;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.tag.Tag;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DungeonsRedstoneCrystalShort extends RedstoneBlock {

    public static final DirectionProperty FACING;
    private static final VoxelShape MAIN_CRYSTAL_X;
    private static final VoxelShape SUB_CRYSTAL_X;
    private static final VoxelShape SUB_CRYSTAL_ONE_X;
    private static final VoxelShape MAIN_CRYSTAL_Z;
    private static final VoxelShape SUB_CRYSTAL_Z;
    private static final VoxelShape SUB_CRYSTAL_ONE_Z;
    private static final VoxelShape CRYSTAL_X;
    private static final VoxelShape CRYSTAL_Z;
    private static int POWER;

    public BlockItem blockItem;

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing().rotateYClockwise());
     }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView view, BlockPos pos, Direction facing) {
        return POWER;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = (Direction)state.get(FACING);
        return direction.getAxis() == Direction.Axis.X ? CRYSTAL_X : CRYSTAL_Z;
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(3.0D, 0.0D, 2.0D, 11.0D, 12.5D, 11.0D);

    public DungeonsRedstoneCrystalShort(Block base, Boolean byHand, Tag<Item> tool, ItemGroup group, int power, String id) {
        super(FabricBlockSettings.copy(base).breakByHand(byHand).breakByTool(tool).build());
        POWER = power;
        Registry.register(Registry.BLOCK, new Identifier(JavaDungeons.MOD_ID, id), this);
        Registry.register(Registry.ITEM,new Identifier(JavaDungeons.MOD_ID, id), blockItem = new BlockItem(this, new Item.Settings().group(group)));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        MAIN_CRYSTAL_X = Block.createCuboidShape(2.0D, 0.0D, 1.0D, 13.0D, 9.0D, 12.0D);
        SUB_CRYSTAL_X = Block.createCuboidShape(5.0D, 0.0D, 11.975D, 10.0D, 5.0D, 15.975);
        SUB_CRYSTAL_ONE_X = Block.createCuboidShape(13.0D, 0.0D, 3.0D, 14.0D, 2.0D, 6.0D);
        MAIN_CRYSTAL_Z = Block.createCuboidShape(1.0D, 0.0D, 3.0D, 12.0D, 9.0D, 14.0D);
        SUB_CRYSTAL_Z = Block.createCuboidShape(3.0D, 0.05D, 2.0D, 6.0D, 2.05D, 3.0D);
        SUB_CRYSTAL_ONE_Z = Block.createCuboidShape(12.0D, 0.05D, 6.0D, 16.0D, 5.05D, 11.00D);
        CRYSTAL_X = VoxelShapes.union(MAIN_CRYSTAL_X, SUB_CRYSTAL_X, SUB_CRYSTAL_ONE_X);
        CRYSTAL_Z = VoxelShapes.union(MAIN_CRYSTAL_Z, SUB_CRYSTAL_Z, SUB_CRYSTAL_ONE_Z);
    }

}