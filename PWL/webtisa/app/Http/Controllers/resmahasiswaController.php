<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;


class resmahasiswaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $title = "Mahasiswa WebTisa.com";
        $slug = "mahasiswa";
        $mahasiswa = "Sinichi Kudo";
        //$dataMahasiswa = $this->show();
        $dataMahasiswa = DB::table('mahasiswa')->get();
        return view('resmahasiswa.index', compact('mahasiswa', 'title', 'slug', 'dataMahasiswa'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id='')
    {
        $id = array(
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

        return $id;
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
