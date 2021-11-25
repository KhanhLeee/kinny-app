package com.sinhvien.kinny;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    //TEND DATABASE
    private static final String TEN_DATABASE = "db_QuanLiCanNang";
    //TEN TABLE
    public static final String TEN_BANG_NGUOIDUNG = "tb_NguoiDung";
    public static final String TEN_BANG_CANNANG = "tb_CanNang";
    public static final String TEN_BANG_MUCTIEU = "tb_MucTieu";


    //CAC COT CUA NGUOIDUNG
    public static final String COT_SODIENTHOAI = "_sodienthoai";
    public static final String COT_MATKHAU = "_matkhau";
    public static final String COT_TEN = "_ten";
    public static final String COT_TUOI = "_tuoi";
    public static final String COT_GIOITINH = "_gioitinh";
    public static final String COT_CHIEUCAO = "_chieucao";
    public static final String COT_CANNANGBD = "_cannangbandau";

    //CAC COT CUA CANNANG
    public static final String COT_ID = "_ID";
    public static final String COT_CANNANG = "_cannang";
    public static final String COT_BMI = "_bmi";
    public static final String COT_NGAYTHEM = "_ngaythem";

    //CAC COT CUA MUCTIEU
    public static final String COT_ = "_bmi";
    public static final String COT_CANNANGMT = "_cannangmuctieu";
    public static final String COT_NGATBATDAU = "_ngaybatdau";
    public static final String COT_NGAYTKETTHUC = "_ngayketthuc";
    public static final String COT_TILEQUATRINH = "_tilequatrinh";
    public static final String COT_SOKYQUATRINH = "_sokyquatrinh";


    private static final String TAO_BANG_NGUOIDUNG= ""
            + "create table " + TEN_BANG_NGUOIDUNG + " ( "
            + COT_SODIENTHOAI + " text primary key, "
            + COT_MATKHAU + " text not null, "
            + COT_TEN + " text, "
            + COT_TUOI + " integer, "
            + COT_GIOITINH + " text, "
            + COT_CHIEUCAO + " real, "
            + COT_CANNANGBD + " real );";

    private static final String TAO_BANG_CANNANG = ""
            + "create table " + TEN_BANG_CANNANG + " ( "
            + COT_ID + " integer primary key autoincrement, "
            + COT_CANNANG + " real, "
            + COT_BMI + " real, "
            + COT_NGAYTHEM + " text, "
            + COT_SODIENTHOAI + " interger not null, Foreign Key (" + COT_SODIENTHOAI + ") "
            + "References " + TEN_BANG_NGUOIDUNG + " (" + COT_SODIENTHOAI + ") );";

    private static final String TAO_BANG_MUCTIEU = ""
            + "create table " + TEN_BANG_MUCTIEU + " ( "
            + COT_ID + " integer primary key autoincrement, "
            + COT_CANNANGMT + " real, "
            + COT_NGATBATDAU + " text, "
            + COT_NGAYTKETTHUC + " text, "
            + COT_SOKYQUATRINH + " real, "
            + COT_TILEQUATRINH + " real, "
            + COT_SODIENTHOAI + " interger not null, Foreign Key (" + COT_SODIENTHOAI + ") "
            + "References " + TEN_BANG_NGUOIDUNG + " (" + COT_SODIENTHOAI + ") );";

    public DBHelper(@Nullable Context context) {
        super(context, TEN_DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_NGUOIDUNG);
        db.execSQL(TAO_BANG_CANNANG);
        db.execSQL(TAO_BANG_MUCTIEU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TEN_BANG_NGUOIDUNG);
        db.execSQL("DROP TABLE IF EXISTS " + TEN_BANG_CANNANG);
        db.execSQL("DROP TABLE IF EXISTS " + TEN_BANG_MUCTIEU);
    }

    //Cac phuong thuc su dung database
    public Boolean themNguoiDung(String sdt, String matkhau) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COT_SODIENTHOAI, sdt);
        contentValues.put(COT_MATKHAU, matkhau);
        long ketqua = myDB.insert(TEN_BANG_NGUOIDUNG, null, contentValues);
        if(ketqua == -1) return false;
        else{
            return true;
        }
    }

    public Boolean kiemtraSDT(String sdt) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from "+ TEN_BANG_NGUOIDUNG + " where "+ COT_SODIENTHOAI+ " =  ?"
                ,new String[] {sdt});
        if(cursor.getCount() > 0){
            return true;
        }
        else
            return false;
    }

    public Boolean kiemtraSDTMatKhau(String sdt, String matkhau) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from "+ TEN_BANG_NGUOIDUNG
                +" where "+ COT_SODIENTHOAI + " = ? and " + COT_MATKHAU + "= ?", new String[] {sdt, matkhau});
        if(cursor.getCount() > 0){
            return true;
        }
        else
            return false;
    }

    @SuppressLint("Range")
    public Boolean kiemtraNguoiDungMoi(String sdt) {
        SQLiteDatabase myDB = this.getWritableDatabase();

        Cursor cursor = myDB.rawQuery("Select " + COT_TEN + " from "+ TEN_BANG_NGUOIDUNG
                +" where " + COT_SODIENTHOAI + " = ?", new String[] {sdt});


        if(cursor.getColumnIndex(COT_TEN) > 0){
            return false;
        }
        else
            return true;
    }

    public Boolean luuThongTinNguoiDung(String ten, int tuoi, String gioitinh, double chieucao, double cannang, String sdt ) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COT_TEN, ten);
        contentValues.put(COT_TUOI, tuoi);
        contentValues.put(COT_GIOITINH, gioitinh);
        contentValues.put(COT_CHIEUCAO, chieucao);
        contentValues.put(COT_CANNANGBD, cannang);

        long ketqua = myDB.update(TEN_BANG_NGUOIDUNG, contentValues, COT_SODIENTHOAI + " = ?" , new String[] {sdt});
        if(ketqua == -1) return false;
        else{
            return true;
        }
    }

    public Cursor layTatcaDuLieu(String sdt) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from " + TEN_BANG_NGUOIDUNG + " where " + COT_SODIENTHOAI + " = ?", new String[] {sdt});

        return cursor;
    }
}
