package com.example.sudentcard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sudentcard.databinding.ActivityMainBinding
import com.example.sudentcard.model.Student
import com.example.sudentcard.utils.toAcademicRanking
import com.example.sudentcard.utils.toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentStudent = Student(
        id = "22505120005",
        name = "Nguyen Van An",
        className = "DD2026",
        email = "anv@ute.udn.vn",
        gpa = 3.8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Khởi tạo ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hiển thị dữ liệu sinh viên ban đầu
        bindStudentData(currentStudent)

        // Xử lý khi bấm nút Cập nhật GPA
        binding.btnUpdateGpa.setOnClickListener {

            val inputStr = binding.edtNewGpa
                .text
                .toString()
                .trim()

            val newGpa = inputStr.toDoubleOrNull()

            // Kiểm tra GPA
            if (newGpa == null || newGpa !in 0.0..4.0) {

                binding.edtNewGpa.error =
                    "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"

                toast("Điểm GPA không hợp lệ!")

                return@setOnClickListener
            }

            // Cập nhật Student
            currentStudent = currentStudent.copy(
                gpa = newGpa
            )

            // Hiển thị lại dữ liệu mới
            bindStudentData(currentStudent)

            toast("Cập nhật điểm thành công!")
        }
    }

    // Hàm đưa dữ liệu Student lên giao diện
    private fun bindStudentData(student: Student) {

        with(binding) {

            tvName.text = student.name

            tvStudentId.text =
                "MSSV: ${student.id} • Lớp: ${student.className}"

            tvGpaBadge.text =
                "${student.gpa} GPA (${student.gpa.toAcademicRanking()})"

            edtNewGpa.setText(
                student.gpa.toString()
            )
        }
    }
}