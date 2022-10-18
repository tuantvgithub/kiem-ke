package com.hust.gr.inventory.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

    @UtilityClass
    public class InventorySheet {
        public static final String KEY_FILTER_BY_CODE = "code";
        public static final String KEY_FILTER_BY_STATUS = "status";
    }

    @UtilityClass
    public class Microservice {
        @UtilityClass
        public class Storage {
            public static final String NAME = "m-storage";
            public static final String END_POINT = "http://localhost:9002/api/storage";
            public static final String GET_FILE_API_URI = "/v1/files";
        }
    }
}
