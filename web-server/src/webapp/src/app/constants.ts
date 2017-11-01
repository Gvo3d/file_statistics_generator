export class Constants {
    public static get HOME_URL(): string {
        return "http://localhost:8080";
    };

    public static get FILE_LIST(): string {
        return "/files/list";
    };

    public static get FILE_PAGE(): string {
        return "/files/one?id=";
    };

    public static get FILE_PAGES_COUNT(): string {
        return "/files/pagesCount";
    };
}
