package Generalization;

public class KepalaDesa extends PegawaiDesa {

    public KepalaDesa(String nama) {
        super(nama, "Kepala Desa");
    }

    @Override
    public void bekerja() {
        System.out.println("Kepala Desa " + nama + " sedang memimpin rapat dan menandatangani surat keputusan.");
    }
}

