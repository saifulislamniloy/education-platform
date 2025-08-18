package io.github.saifulislamniloy.education_platform.constant;

public class SwaggerConstant {
    public static class CourseController {
        public static class SaveCourse {
            public static final String SUMMARY = "Create course";
            public static final String DESCRIPTION = "Create course like database, operating system etc.";


            public static final String OPERATING_SYSTEM = "Operating System";

            public static final String OPERATING_SYSTEM_VALUE = """
                    {
                       "name": "Operating System",
                       "description": "A core subject in Computer Science and Engineering.",
                       "bannerImageUrl": "https://example-image.png"
                     }
                    """;


            public static final String DATABASE = "Database";

            public static final String DATABASE_VALUE = """
                    {
                       "name": "Database Management System",
                       "description": "A core subject in Computer Science and Engineering.",
                       "bannerImageUrl": "https://example-image.png"
                     }
                    """;
        }
    }

    public static class MetaData {
        public static final String HTTP_OK_CODE = "200";
        public static final String HTTP_NOT_FOUND_CODE = "404";
        public static final String HTTP_INTERNAL_SERVER_ERROR_CODE = "500";
        public static final String HTTP_OK_DESCRIPTION = "Request successful";
        public static final String HTTP_INTERNAL_SERVER_ERROR = "Internal server error";
        public static final String MEDIA_TYPE_JSON = "application/json";
    }
}
