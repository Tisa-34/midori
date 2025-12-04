<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class mhsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {

        DB::table('mahasiswa')->insert(array(
            ['nim' => '9704005',
            'nama' => 'Kudo Shinichi',
            'prodi' => 'S1Hukum',
            'angkatan' => '1997'],

            ['nim' => '9704006',
            'nama' => 'Hattori Heiji',
            'prodi' => 'S1Hukum',
            'angkatan' => '1997'
            ]
        ));
    }
}
