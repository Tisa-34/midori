<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\mahasiswaController;
use App\Http\Controllers\prodiController;
use App\Http\Controllers\resmahasiswaController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {
    return view ('welcome');
});
/*
Route::get('/mahasiswa', [mahasiswaController::class, 'index'])->name('mahasiswa');
*/
Route::get('/mahasiswa/show', [mahasiswaController::class, 'show'])->name('mahasiswa-show');

Route::get('/mahasiswa/perulangan', [mahasiswaController::class, 'perulangan'])->name('mahasiswa-perulangan');

Route::get('/', function () {
    $title = "WebTisa.Com";
    $slug = "home";
    $konten = "Ini adalah konten WebTisa.Com";
    return view('konten.home', compact('title', 'slug', 'konten'));
});

Route::get('/home', function(){
    $title = "WebTisa.Com";
    $slug = "home";
    $konten = "Ini adalah konten WebTisa.Com";
    return view('konten.home', compact('title', 'slug', 'konten'));
});


Route::get('/mahasiswa', [mahasiswaController::class, 'index']);

Route::resource('resmahasiswa',resmahasiswaController::class);

Route::get('/prodi', [prodiController::class, 'index']);

