package org.yakimovdenis.console.support;

public class QueryConstants {
    public final static String SAVE_LINE_STATISTIC = "INSERT INTO line_statistics (line, longest_word, shortest_word, average_word_length, file_id) values (:line, :longest_word, :shortest_word, :average_word_length, :file_id)";
    public final static String SAVE_FILE_STATISTIC = "INSERT INTO files (filename, created) values (:file_name, :upload_date)";
    public final static String GET_LINES = "SELECT * FROM line_statistics WHERE file_id = :file_id";
    public final static String GET_FILE = "SELECT * FROM files WHERE id = :file_id";
    public final static String GET_FILE_NAMES = "SELECT * FROM files";
    public final static String DELETE_FILE = "DELETE FROM files WHERE id = :file_id";
}