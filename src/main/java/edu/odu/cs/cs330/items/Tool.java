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
    "PMD.ShortClassName",
})
public class Tool extends Equippable implements Item {
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %d%n",
        "  Spd: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n"
    );

    protected int speed;

    public Tool()
    {
        super();
        this.speed = 0;
    }

    public int getSpeed()
    {
        return this.speed;
    }

    public void setSpeed(int spd)
    {
        this.speed = spd;
    }

    @Override
    public Item clone()
    {
        Tool cpy = new Tool();
        
        cpy.setName(this.getName());
        cpy.setMaterial(this.getMaterial());
        cpy.setDurability(this.getDurability());
        cpy.setSpeed(this.getSpeed());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());

        return cpy;
    }

    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Tool)) {
            return false;
        }

        Tool rhsItem = (Tool) rhs;

        return this.name.equals(rhsItem.name)
            && this.speed == rhsItem.speed
            && this.getMaterial().equals(rhsItem.getMaterial())
            && this.getModifier().equals(rhsItem.getModifier())
            && this.getModifierLevel() == rhsItem.getModifierLevel();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
            this.getName(),
            this.getSpeed(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel()
        );
    }

    @Override
    public String toString()
    {
        return String.format(FMT_STR,
            this.getName(),
            this.getDurability(),
            this.getSpeed(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel()
        );
    }
}