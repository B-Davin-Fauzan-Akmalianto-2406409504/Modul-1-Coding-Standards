# Reflection 1
- Dari segi clean code, saya sudah berusaha mengaplikasikannya, yaitu yang paling simple adalah penulisan variable pada function editProduct ataupun deleteProduct. Dalam function editProduct, saya dengan jelas membedakan variable productLama dengan productBaru agar terlihat jelas perbedaan antara keduanya.
- Untuk secure coding standards, saya mengganti type input pada quantity product yang tadinya text menjadi number. Hal ini membuat isian tersebut hanya dapat diisi oleh angka.
- Masih banyak kesalahan yang saya lakukan, terutama pada secure coding standard, dimana saya kurang melakukan validasi input terhadap nama produk. Kemudian, mungkin ada beberapa ketidakkonsistenan dalam penamaan variable, seperti kadang id, kadang productId, dan semacamnya.

# Reflection 2
- Saya rasa untuk segi banyaknya unit test sudah cukup untuk sekarang, karna test sudah hampir mencakup semua function dan/atau atribut. Pada function edit dan delete juga sudah dibuat test saat kondisi gagal ataupun sukses.
- Kalau code coverage mencapai 100%, itu hanya memastikan kode berjalan sesuai apa yang ditulis, bukan berarti akan sesuai yang kita inginkan. Bisa juga ada edge cases yang lupa ditest namun tetap memberikan coverage 100%.
- Sebenarnya function test yang ku buat itu belum efisien, karena setupnya tidak difokuskan ke satu file saja melainkan semua file punya setup masing masing. Seharusnya, setup dilakukan sekali dalam satu file, kemudian test2 lainnya bisa inherit setup tersebut sehingga dapat mengefisienkan kode. 
