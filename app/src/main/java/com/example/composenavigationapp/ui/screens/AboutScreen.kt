package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NilaiScreen() {
    var nilai by remember { mutableStateOf("") }
    var hasilNilai by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Kira-kira berapa nilainya pak?")

        OutlinedTextField(
            value = nilai,
            onValueChange = { nilai = it },
            label = { Text("Nilai") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (nilai.isNotBlank()) {
                    hasilNilai = nilai // simpan nilai saat tombol ditekan
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Submit")
        }

        if (hasilNilai.isNotBlank()) {
            Text(
                if (hasilNilai.toInt() < 75) "Maaf, nilainya tidak bisa di bawah 75" else "$hasilNilai? Terima kasih pak!",
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}
