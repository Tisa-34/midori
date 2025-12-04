@extends('layouts.main')
@section('title',$title)
@section('content')
        <h2>Program Studi : {{ $prodi }}</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">KODE PRODI</th>
                        <th scope="col">NAMA PRODI</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($dataProdi as $item)
                    <tr>
                        <td>{{ $item['kdProdi'] }}</td>
                        <td>{{ $item['namaProdi'] }}</td>
                    </tr>
                    @endforeach
                </tbody>
            </table>
@endsection
