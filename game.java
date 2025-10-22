package games;

import java.util.*;

abstract class NhanVat {
    protected String name;
    protected int hp;
    protected int baseDamage;

    public NhanVat(String name, int hp, int baseDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    // lớp con thi trien kn rieng
    public abstract void tanCong();
}

interface TanCongTamXa {
    void tanCongTamXa();
}

interface PhepThuat {
    void thiTrienPhep();
}

class ChienBinh extends NhanVat {
    public ChienBinh(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void tanCong() {
        System.out.println(name + " Arthur (Warrior) attacks with a sword!");
    }
}

class CungThu extends NhanVat implements TanCongTamXa {
    public CungThu(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void tanCongTamXa() {
        System.out.println(name + " Legolas (Archer) shoots an arrow!");
    }

    @Override
    public void tanCong() {
        tanCongTamXa();
    }
}

class PhapSu extends NhanVat implements PhepThuat {
    public PhapSu(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void thiTrienPhep() {
        System.out.println(name + " Gandalf (Mage) casts a fireball");
    }

    @Override
    public void tanCong() {
        thiTrienPhep();
    }
}

class CungThuPhep extends NhanVat implements TanCongTamXa, PhepThuat {
    public CungThuPhep(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void tanCongTamXa() {
        System.out.println(name + " Sylvanas (ArcaneArcher) shoots an arrow!");
    }

    @Override
    public void thiTrienPhep() {
        System.out.println(name + " Sylvanas also casts a magic spell!");
    }

    @Override
    public void tanCong() {

        tanCongTamXa();
    }
}

public class a {
    public static void main(String[] args) {
        List<NhanVat> party = new ArrayList<>();
        party.add(new ChienBinh("Arthur", 150, 25));
        party.add(new CungThu("Legolas", 120, 18));
        party.add(new PhapSu("Gandalf", 100, 30));
        party.add(new CungThuPhep("Sylvanas", 110, 20));

        for (NhanVat nv : party) {
            nv.tanCong();
            if (nv instanceof PhepThuat && !(nv instanceof PhapSu)) {
                ((PhepThuat) nv).thiTrienPhep();
            }
        }
    }
}