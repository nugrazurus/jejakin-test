const fs = require('fs');

function readLog(keywords) {
    // read file './log.log'
    fs.readFile('./log.log', ((err, data) => {
        // Print error di console ketika gagal membaca file
        if (err) {
            console.error("Gagal membaca file", err);
        }

        // Mengubah data yang dibaca menjadi string dan di split berdasarkan line break
        const lines = data.toString().split('\n');
        
        // Mengubah keyword dengan bentuk array ke object
        const browser = keywords.reduce((obj, word) => {
            obj[word] = 0;
            return obj;
        }, {})

        // Iterasi perbaris untuk dan menghitung kata sesuai keyword
        for (i in lines) {
            for(j in keywords) {
                if (lines[i].includes(keywords[j])) {
                    browser[keywords[j]] += 1;
                }
            }
        }

        // print hasil perhitungan keyword di console
        console.log(browser)
    }))
}

readLog(['Mozilla', 'Google', 'Safari']);