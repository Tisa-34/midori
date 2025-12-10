<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class prodiController extends Controller
{
    /*
    public function index(){
        $prodi = "Teknik Informatika";
        $title = "Program Studi WebTisa.com";
        $slug = "prodi";
        return view('konten.prodi', compact('prodi','title', 'slug'));


    }
        */
/*
    public function dataProdi(){
        $dataProdi = array(
            ['kdProdi' => '001',
            'namaProdi' => 'Teknik Mesin'],

            ['kdProdi' => '002',
            'namaProdi' => 'Perancangan Manufaktur'],

            ['kdProdi' => '003',
            'namaProdi' => 'Teknik Informatika']
        );

    }

    public function index(){
        $title = "Program Studi WebTisa.com";
        $slug = "prodi";
        $prodi = "Teknik Informatika";
        $dataProdi = $this->dataProdi();

        return view('konten.prodi', compact('prodi','title', 'slug', 'dataProdi'));


    }
*/
    /*
    public function index()
{
    $title = "WebTisa.Com";
    $prodi = "Daftar Program Studi";

    $dataProdi = [
        ['kdProdi' => 'TI', 'namaProdi' => 'Teknik Informatika'],
        ['kdProdi' => 'SI', 'namaProdi' => 'Sistem Informasi'],
        ['kdProdi' => 'TK', 'namaProdi' => 'Teknik Komputer'],
    ];

    return view('konten.prodi', compact('title', 'prodi', 'dataProdi'));
}

    */

    public function index(){
    $title = "Program Studi WebTisa.com";
    $slug = "prodi";
    $prodi = "Teknik Informatika";

    $dataProdi = [
        ['kdProdi' => '001', 'namaProdi' => 'Teknik Mesin'],
        ['kdProdi' => '002', 'namaProdi' => 'Perancangan Manufaktur'],
        ['kdProdi' => '003', 'namaProdi' => 'Teknik Informatika']
    ];

    return view('konten.prodi', compact('prodi','title', 'slug', 'dataProdi'));
}

}
