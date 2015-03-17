/*
 * Copyright (c) 2015. Sevan Joe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sevanjoe.sourcecounter;

import com.sevanjoe.sourcecounter.utils.FileUtil;

import java.io.File;
import java.util.List;

public class Main {

    private static final String PATH_PROJECT = "C:\\Users\\jiao-9\\Documents\\Personal\\Workspace\\WakeCar\\app\\src\\main";
    private static final String PATH_SRC = "java";
    private static final String PATH_RES = "res";
    private static final String SUFFIX_SRC = "java";
    private static final String SUFFIX_RES = "xml";

    public static void main(String[] args) {
	    // write your code here
        if (FileUtil.isExistNotCreate(PATH_PROJECT)) {
            String srcPath = PATH_PROJECT + File.separator + PATH_SRC;
            if (FileUtil.isExistNotCreate(srcPath)) {
                List<File> srcFileList = FileUtil.getAllFiles(srcPath, SUFFIX_SRC);
                System.out.println("Total Source File Count: " + srcFileList.size());
                int srcTotalCount = 0;
                int srcNoEmptyTotalCount = 0;
                for (File file : srcFileList) {
                    srcTotalCount += FileUtil.getLineCount(file);
                    srcNoEmptyTotalCount += FileUtil.getLineCountNoEmpty(file);
                }
                System.out.println("Total Source Line Count: " + srcTotalCount);
                System.out.println("Total Source Line No Empty Count: " + srcNoEmptyTotalCount);
            }
            String resPath = PATH_PROJECT + File.separator + PATH_RES;
            if (FileUtil.isExistNotCreate(resPath)) {
                List<File> resFileList = FileUtil.getAllFiles(resPath, SUFFIX_RES);
                System.out.println("Total Resource File Count: " + resFileList.size());
                int resTotalCount = 0;
                int resNoEmptyTotalCount = 0;
                for (File file : resFileList) {
                    resTotalCount += FileUtil.getLineCount(file);
                    resNoEmptyTotalCount += FileUtil.getLineCountNoEmpty(file);
                }
                System.out.println("Total Resource Line Count: " + resTotalCount);
                System.out.println("Total Resource Line No Empty Count: " + resNoEmptyTotalCount);
            }
        }
    }
}
