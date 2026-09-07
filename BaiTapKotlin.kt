fun main() {
    print("Nhap Ho ten sinh vien: ")
    var hoTen = readln()
    print("Nhap ma sinh vien: ")
    var maSV = readln()
    print("Nhap diem Math: ")
    var math = readln().toDouble()
    print("Nhap diem Programming: ")
    var program = readln().toDouble()
    print("Nhap diem Database : ")
    var database = readln().toDouble()

    var tong = math+program+database
    var gpa = tong / 3
    var diemCaoNhat = maxOf(math,program, database)
    var ketQua = if (gpa >=5.0){
        "Dat"
    }else {
        "Khong dat"
    }
    println("Họ tên: $hoTen")
    println("Mã sinh viên: $maSV")
    println("Math: $math")
    println("Programming: $program")
    println("Database: $database")

    println()
    println("Sinh viên: $hoTen - Mã SV: $maSV")
    println("Tổng điểm: $tong")
    println("Điểm trung bình (GPA): %.2f".format(gpa))
    println("Điểm cao nhất: $diemCaoNhat")
    println("Sinh viên có đạt không: $ketQua")
}