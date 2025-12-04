<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>WebTisa.com</title>
</head>
<body>
    <!-- <h1>Selamat Datang "{{ $mahasiswa }}" di WebTisa.com</h1> -->
    <h1>Selamat Datang "{{isset ($mahasiswa) ? $mahasiswa : 'Tidak Ada' }}" di WebTisa.com</h1>

</body>
</html>
