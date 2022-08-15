/*
 * Copyright (c) 2019-2021 C4
 *
 * This file is part of Trinket Shulker Boxes, a mod made for Minecraft.
 *
 * Trinket Shulker Boxes is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Trinket Shulker Boxes is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Trinket Shulker Boxes. If not, see <https://www.gnu.org/licenses/>.
 */

package top.theillusivec4.trinketshulkerboxes.common;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class TrinketShulkerBox implements Trinket {

  @Override
  public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
    try {
      TrinketShulkerBoxesMod.TRINKET_SHULKER_BOX_COMPONENT.maybeGet(stack).ifPresent(
          TrinketShulkerBoxComponent::tick);
    } catch (IllegalStateException e) {
      TrinketShulkerBoxesMod.LOGGER.error("Cannot obtain component for shulker box!");
      e.printStackTrace();
    }
  }
}
