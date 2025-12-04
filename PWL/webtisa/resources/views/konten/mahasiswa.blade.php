@extends('layouts.main')
@section('title',$title)
@section('content')
        <h2>Nama : {{ $mahasiswa }}</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">NIM</th>
                        <th scope="col">NAMA</th>
                        <th scope="col">PRODI</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($dataMahasiswa as $item)
                    <tr>
                        <td>{{ $item['nim'] }}</td>
                        <td>{{ $item['nama'] }}</td>
                        <td>{{ $item['prodi'] }}</td>
                    </tr>
                    @endforeach
                </tbody>
            </table>
@endsection
