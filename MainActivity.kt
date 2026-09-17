package com.example.studentprofilecard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofilecard.databinding.ActivityMainBinding
import com.example.studentprofilecard.model.Student
import com.example.studentprofilecard.utils.XepLoaiHocLuc
import com.example.studentprofilecard.utils.showConfirmDialog
import com.example.studentprofilecard.utils.toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var std = Student(
        id = "2415053122106",
        name = "Phạm Công Đạt",
        className = "24T1",
        email = "dat@gmail.com",
        phone = "0385830142",
        gpa = 3.2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindStudentData(std)

        binding.btnUpdate.setOnClickListener {

            val inputStr = binding.edtGPA.text.toString().trim()
            val newGPA = inputStr.toDoubleOrNull()

            if (newGPA == null || newGPA < 0.0 || newGPA > 4.0) {

                binding.edtGPA.error =
                    "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"

                toast("Điểm GPA không hợp lệ!")

                return@setOnClickListener
            }

            std = std.copy(
                gpa = newGPA
            )

            bindStudentData(std)

            toast("Cập nhật điểm thành công!")
        }

        binding.btnCall.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${std.phone}")
            }

            startActivity(intent)
        }
        binding.btnDelete.setOnClickListener {

            showConfirmDialog(
                title = "Xác nhận xóa",
                message = "Bạn có chắc chắn muốn xóa hồ sơ này không?"
            ) {

                binding.cardView.visibility = android.view.View.GONE

                toast("Đã xóa hồ sơ!")
            }
        }
    }
    private fun bindStudentData(std: Student) {

        with(binding) {

            txtTen.text = std.name

            txtMaSinhVien.text =
                "MSV: ${std.id}  Lớp: ${std.className}"

            txtSoDienThoai.text =
                "SĐT: ${std.phone}"

            txtDiem.text =
                "${std.gpa} GPA"

            txtGPA.text =
                "(${std.gpa.XepLoaiHocLuc()})"

            edtGPA.setText(
                std.gpa.toString()
            )
        }
    }
}