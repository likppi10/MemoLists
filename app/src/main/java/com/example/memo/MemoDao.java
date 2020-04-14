package com.example.memo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MemoDao  {
    @Insert
    void addData(MemoDatalist memodatalist);

/*    @Delete
    int
    delete(MyDatalist mydatalist);
    @Query("delete from mydatalist WHERE id = :Id")
    List<MyDatalist> delete(int Id ,String name ,String email ,String city);*/

    @Update
    public void update(MemoDatalist memodatalist);

    @Query("select * from memodatalist where id = :id")
    List<MemoDatalist> load(int id);


    @Query("select * from memodatalist")
    public List<MemoDatalist> getMemoData();

    @Query ("delete from memodatalist where id = :id")
    public void  deleteData(int id);


    @Query ("update memodatalist set memo = :setmemo where id = :posid")
    public void  updatememo(String setmemo, int posid);


}