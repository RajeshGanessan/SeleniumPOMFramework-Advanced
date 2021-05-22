package com.framework.utils.TryWithResouces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryResourcesRunner {

    public static void main(String[] args) {


    }

    private static  void readExcelData(){

        try(FileInputStream fis =  new FileInputStream("")){
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
