import kotlin.math.sinh

class SinhVien(
    var studentID: String,
    var fullName: String?,
    var age: Int,
    var major: String,
    var gpa: Double
)
val sv = mutableListOf(
    SinhVien("SV001", "Pham Cong Dat", 20, "CNTT", 8.5),
    SinhVien("SV002", "Vo Thien Toan", 21, "Marketing", 7.2),
    SinhVien("SV003", "Huynh Nhat Son", 22, "CNTT", 9.1),
    SinhVien("SV004", "Ngo Tan Hoang Giang", 19, "Logistic", 4.5),
    SinhVien("SV005", "Dinh Gia Bao", 23, "CNTT", 6.8)
)
fun HienThiThongTin(sinhVien: SinhVien){
    println("Student ID: ${sinhVien.studentID} " +
            " FullName: ${sinhVien.fullName} " +
            " Age: ${sinhVien.age} " +
            " Major: ${sinhVien.major} " +
            " GPA: ${sinhVien.gpa} "
    )
}
fun findSV(id : String): SinhVien?{
    for (s in sv ){
        if (s.studentID.equals(id,ignoreCase = true))
            return s
    }
    return null
}
fun ThemSinhVien(){
    println("Nhap Student ID: ")
    val id =readLine()!!
    if (findSV(id) != null) {
        println("Student ID da ton tai. Khong the them!")
        return
    }
    println("Nhap FullName: ")
    val name = readLine()
    println("Nhap Age: ")
    val year= readLine()!!.toInt()
    println("Nhap Major: ")
    val specialized = readLine()!!
    println("Nhap gpa: ")
    val diem = readLine()!!.toDouble()
    sv.add(SinhVien(id,name,year,specialized,diem))
    println("Da them sinh vien!")
}
fun TimKiemSinhVien(){
    println("Nhap Student ID can tim kiem: ")
    val id = readLine()!!
     var find = false
    for (s in sv){
        if(s.studentID.equals(id, ignoreCase = true)) {
            HienThiThongTin(s)
            find = true
        }
    }
    if (find==false){
        println("Khong tim thay sinh vien")
    }
}
fun TinhAverageGPA(){
    if(sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    var tong =0.0
    for (s in sv){
        tong+= s.gpa
    }
    var gpaTrungBinh = tong / sv.size
    println("GPA trung binh: %.2f".format(gpaTrungBinh))
}
fun TimGPACaoNhat(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    var max: SinhVien = sv[0]
    for (s in sv){
        if(max.gpa < s.gpa){
            max = s
        }
    }
    println("Sin vien co GPA cao nhat: ")
    HienThiThongTin(max)
}

fun RemoveSinhVien(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Nhap Student ID can xoa: ")
    val id = readln()!!

    val student: SinhVien? = findSV(id)
    if (student!= null){
        sv.remove(student)
        println("Da xoa sinh vien!")
    } else{
        println("Khong tim thay sinh vien")
    }
}
fun DemSVCoGPALonHon8(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    var dem = 0
    for (s in sv){
        if (s.gpa>=8.0)
            dem +=1
    }
    println("Co ${dem} sinh vien co GPA >= 8")
}
fun DemSVCoGPANhoHon5(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    var dem = 0
    for (s in sv){
        if (s.gpa < 5.0)
            dem+= 1
    }
    println("Co ${dem} so sinh vie co GPA < 5.0")
}
fun GPAByMajor(){   
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Nhap vao ten nghanh can tinh GPA trung binh: ")
    var tenNganh = readln()

    var gpaTotal = 0.0
    var dem = 0
    for (s in sv){
        if (s.major.equals(tenNganh, ignoreCase = true)){
            dem += 1
            gpaTotal += s.gpa
        }
    }
    if (dem!=0) {
        val gpaAverage = gpaTotal / dem
        println("GPA trung binh theo nganh ${tenNganh} la: %.2f".format(gpaAverage))
    }else {
        println("Khong tim thay sinh vien trong nghanh ${tenNganh}")
    }
}
fun SinhVienCoTuoiLonNhat(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    var maxAge: SinhVien = sv[0]
    for (s in sv){
        if (maxAge.age!! < s.age!!){
            maxAge = s
        }
    }
    HienThiThongTin(maxAge)

}
fun TimSVTheoGPA(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    var dem = 0
    for (s in sv){
        if (s.gpa <= 8.5 &&  s.gpa>=7.0){
            HienThiThongTin(s)
            dem+=1
        }
    }
    if (dem==0){
        println("Khong tim thay sinh nao co GPA nam trong khoang 7.0 -> 8.0")
    }
}
fun TimSVTheoNganh(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Nhap vao ten nganh phu hop: ")
    val tenNganh = readln()!!
    var find = false
    for (s in sv){
        if (s.major.equals(tenNganh, ignoreCase = true)){
            HienThiThongTin(s)
            find = true
        }
    }
    if (!find){
        println("Khong tim thay sinh vien theo nganh ${tenNganh}")
    }
}
fun TimSVTheoTen(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Nhap vao ten sinh vien can tim kiem: ")
    val ten= readln()!!
    var find = false
    for (s in sv){
        if (s.fullName!!.contains(ten, ignoreCase = true)){
            HienThiThongTin(s)
            find = true
        }
    }
    if (!find){
        println("Khong tim thay sinh vien co ten '${ten}'. ")
    }
}
fun SapXepGiamTheoGPA(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println(" Danh sach sinh vien sa xep giam dan theo GPA:")
    sv.sortByDescending { it.gpa }
    for (s in sv){
        HienThiThongTin(s)
    }
}
fun HienThiTop3(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Top 3 sinh vien co GPA cao nhat.")
    val students = sv.sortedByDescending{it.gpa}.take(3)
    for (s in students){
        HienThiThongTin(s)
    }
}
fun SapXepSVTheoTuoi(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Danh sach SV duoc sap xep theo tuoi (Giam dan): ")
    sv.sortByDescending{it.age}
    for (s in sv){
        HienThiThongTin(s)
    }
}
fun SapXepSVTheoTen(){
    if (sv.isEmpty()){
        println("Danh sach sinh vien rong.")
        return
    }
    println("Danh sach SV duoc sap xep theo ten: ")
    sv.sortBy { it.fullName }
    for (s in sv){
        HienThiThongTin(s)
    }
}
fun MenuMoRong() {
    while (true) {
        println()
        println("========== CHUC NANG MO RONG ==========")
        println("1. Dem sinh vien co GPA >= 8.0")
        println("2. Dem sinh vien co GPA < 5.0")
        println("3. Tinh GPA trung binh theo nganh")
        println("4. Tim sinh vien lon tuoi nhat")
        println("5. Tim sinh vien co GPA tu 7.0 den 8.5")
        println("6. Tim tat ca sinh vien theo nganh")
        println("7. Tim sinh vien theo mot phan ten")
        println("8. Sap xep sinh vien theo GPA giam dan")
        println("9. Hien thi 3 sinh vien co GPA cao nhat")
        println("10. Sap xep sinh vien theo tuoi")
        println("11. Sap xep sinh vien theo ten")
        println("0. Quay lai")
        println("=======================================")
        print("Chon: ")

        when (readln().toInt()) {
            1 -> DemSVCoGPALonHon8()
            2 -> DemSVCoGPANhoHon5()
            3 -> GPAByMajor()
            4 -> SinhVienCoTuoiLonNhat()
            5 -> TimSVTheoGPA()
            6 -> TimSVTheoNganh()
            7 -> TimSVTheoTen()
            8 -> SapXepGiamTheoGPA()
            9 -> HienThiTop3()
            10 -> SapXepSVTheoTuoi()
            11 -> SapXepSVTheoTen()
            0 -> return
            else -> println("Lua chon khong hop le!")
        }
    }
}
fun main() {
    while (true) {
        println()
        println("========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student")
        println("4. Calculate average GPA")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("7. More functions")
        println("0. Exit")
        println("========================================")
        print("Choose: ")

        when (readln().toInt()) {
            1 -> ThemSinhVien()
            2 -> {
                if (sv.isEmpty()) {
                    println("Danh sach sinh vien rong.")
                } else {
                    for (s in sv) {
                        HienThiThongTin(s)
                    }
                }
            }

            3 -> TimKiemSinhVien()
            4 -> TinhAverageGPA()
            5 -> TimGPACaoNhat()
            6 -> RemoveSinhVien()
            7 -> MenuMoRong()
            0 -> {
                println("Ket thuc chuong trinh.")
                return
            }
            else -> println("Lua chon khong hop le!")
        }
    }
}