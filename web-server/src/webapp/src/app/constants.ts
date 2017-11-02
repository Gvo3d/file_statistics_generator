import {Ng4FilesConfig} from 'angular4-files-upload';

export class Constants {
    public static filesUploadConfig: Ng4FilesConfig = {
        acceptExtensions: '*',
        maxFilesCount: 30,
        maxFileSize: 5120000,
        totalFilesSize: 51200000
    };

    public static get HOME_URL(): string {
        return "http://localhost:8080";
    };

    public static get FILE_LIST(): string {
        return "/files/list";
    };

    public static get FILE_PAGE(): string {
        return "/files/one?id=";
    };

    public static get UPLOAD(): string {
        return "/files/upload";
    };

}
