/*
 * Work under Copyright. Licensed under the EUPL.
 * See the project README.md and LICENSE.txt for more information.
 */

package net.dries007.tfc.jei.wrappers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import net.dries007.tfc.jei.IJEIRecipeWrapper;

public class WeldingWrapper extends TFCRecipeWrapper
{
    public WeldingWrapper(IJEIRecipeWrapper recipe)
    {
        super(recipe);
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        NonNullList<ItemStack> inputs1 = getRecipeWrapper().getItemIngredients().get(0).getValidInputList();
        NonNullList<ItemStack> inputs2 = getRecipeWrapper().getItemIngredients().get(1).getValidInputList();
        List<List<ItemStack>> allInputs = new ArrayList<>(2);
        allInputs.add(inputs1);
        allInputs.add(inputs2);
        ingredients.setInputLists(VanillaTypes.ITEM, allInputs);
        ingredients.setOutput(VanillaTypes.ITEM, getRecipeWrapper().getItemOutputs().get(0));
    }
}