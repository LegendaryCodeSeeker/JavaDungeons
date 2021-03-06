package j0sh.javadungeons.biome;

import j0sh.javadungeons.content.CactiCanyonBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.feature.VillageFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public final class CactiCanyonDesertBiome extends Biome {
   public CactiCanyonDesertBiome() {
      super((new Biome.Settings()).configureSurfaceBuilder(SurfaceBuilder.DEFAULT, 
        new TernarySurfaceConfig(CactiCanyonBlocks.CC_SAND.getDefaultState(), CactiCanyonBlocks.CC_SANDSTONE.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
        .precipitation(Biome.Precipitation.NONE).category(Biome.Category.DESERT)
        .depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.0F).waterColor(4159204).waterFogColor(329011)
        .parent((String)null));

      this.addStructureFeature(Feature.VILLAGE.configure(new VillageFeatureConfig("village/desert/town_centers", 6)));
      this.addStructureFeature(Feature.PILLAGER_OUTPOST.configure(FeatureConfig.DEFAULT));
      this.addStructureFeature(Feature.DESERT_PYRAMID.configure(FeatureConfig.DEFAULT));
      this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));
      this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
      DefaultBiomeFeatures.addLandCarvers(this);

      DefaultBiomeFeatures.addDefaultStructures(this);
      DefaultBiomeFeatures.addDesertLakes(this);
      DefaultBiomeFeatures.addDungeons(this);
      DefaultBiomeFeatures.addMineables(this);
      DefaultBiomeFeatures.addDefaultOres(this);
      DefaultBiomeFeatures.addDefaultDisks(this);
      DefaultBiomeFeatures.addDefaultFlowers(this);
      DefaultBiomeFeatures.addDefaultGrass(this);
      DefaultBiomeFeatures.addDesertDeadBushes(this);
      DefaultBiomeFeatures.addDefaultMushrooms(this);
      DefaultBiomeFeatures.addDesertVegetation(this);

      DefaultBiomeFeatures.addSprings(this);
      DefaultBiomeFeatures.addDesertFeatures(this);
      DefaultBiomeFeatures.addFrozenTopLayer(this);
      this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
      this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 19, 4, 4));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
      this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.HUSK, 80, 4, 4));
   }
}
