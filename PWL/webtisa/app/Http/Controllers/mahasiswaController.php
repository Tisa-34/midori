<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class mahasiswaController extends Controller
{

    /*
    public function index(){
        $mahasiswa = "Kudo Shinichi";
        return view('mahasiswa/index', compact('mahasiswa'));
    }
    */

    public function show(){
        $mahasiswa = ['Kudo Shinichi', 'Kuroba Kaito', 'Hattori Heiji'];
        return view('mahasiswa/show', compact('mahasiswa'));
    }

    public function perulangan(){
        $mahasiswa = ['Kudo Shinichi', 'Kuroba Kaito', 'Hattori Heiji'];
        return view('mahasiswa/perulangan', compact('mahasiswa'));
    }

    /*
    public function index(){
        $mahasiswa = "Sinichi Kudo";
        $title = "Mahasiswa WebTisa.com";
        $slug = "mahasiswa";
        return view('konten.mahasiswa', compact('mahasiswa', 'title', 'slug'));
    }
        */

    public function dataMahasiswa(){
        $dataMahasiswa = array(
            ['nim' => '9704005',
            'nama' => 'Kudo Shinichi',
            'prodi' => 'S1Hukum',
            ],

            ['nim' => '9704006',
            'nama' => 'Hattori Heiji',
            'prodi' => 'S1Hukum',
            ],

            ['nim' => '9704007',
            'nama' => 'Kuroba Kaito',
            'prodi' => 'S1Hukum',
            ]

        );
        return $dataMahasiswa;
    }

    public function index(){
        $title = "Mahasiswa WebTisa.com";
        $slug = "mahasiswa";
        $mahasiswa = "Sinichi Kudo";
        $dataMahasiswa = $this->dataMahasiswa();
        return view('konten.mahasiswa', compact('mahasiswa', 'title', 'slug', 'dataMahasiswa'));
    }
}
