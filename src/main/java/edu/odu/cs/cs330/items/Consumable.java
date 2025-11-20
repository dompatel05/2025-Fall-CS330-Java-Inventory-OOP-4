package edu.odu.cs.cs330.items;

import java.util.Objects;

@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.BeanMembersShouldSerialize"
})
public class Consumable implements Item {
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Eft: %s%n",
        "  Use: %d%n"
    );

    protected String name;
    protected String effect;
    protected int uses;

    public Consumable()
    {
        this.name = "[Placeholder]";
        this.effect = "";
        this.uses   = 0;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(final String nme)
    {
        this.name = nme;
    }

    public String getEffect()
    {
        return this.effect;
    }

    public void setEffect(String newEff)
    {
        this.effect = newEff;
    }

    public int getNumberOfUses()
    {
        return this.uses;
    }

    public void setNumberOfUses(int allowed)
    {
        this.uses = allowed;
    }

    @Override
    public boolean isStackable()
    {
        return true;
    }

    @Override
    public Item clone()
    {
        Consumable cpy = new Consumable();
        
        cpy.setName(this.getName());
        cpy.setEffect(this.getEffect());
        cpy.setNumberOfUses(this.getNumberOfUses());

        return cpy;
    }

    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Consumable)) {
            return false;
        }

        Consumable rhsItem = (Consumable) rhs;

        return this.name.equals(rhsItem.name)
            && this.effect.equals(rhsItem.effect);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode() + this.effect.hashCode();
    }

    @Override
    public String toString()
    {
        return String.format(FMT_STR,
            this.getName(),
            this.getEffect(),
            this.getNumberOfUses()
        );
    }
}