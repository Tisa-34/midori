<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Perulangan Kontrol WebTisa.com</title>
</head>
<body>

    <h3>Perulangan FOR</h3>
    @for ($i=0; $i < count($mahasiswa); $i++ )
        {{ 'Nama: '. $mahasiswa[$i] }} <br>

    @endfor

    <hr>

    <h3>Perulangan FOREACH</h3>
    @foreach ($mahasiswa as $item)
        {{ 'Nama '. $item }} <br>

    @endforeach

    <hr>

    <h3>Perulangan WHILE</h3>
    @php
        $x=0;
    @endphp
    @while ($x < count($mahasiswa))
        {{ 'Nama: '. $mahasiswa[$x] }} <br>

        @php
            $x++;
        @endphp

    @endwhile

    <hr>

</body>
</html>
