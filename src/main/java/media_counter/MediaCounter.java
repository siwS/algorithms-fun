package media_counter;

import java.util.*;

/**
 * MediaCounter Class
 * Takes a list that contains all the files of a system and returns how many of each type are there.
 * by @sofia
 */
public class MediaCounter {

    enum FileType {
        MUSIC,
        MOVIE,
        IMAGE,
        OTHER
    }

    class File {
        List<String> musicTypes = Arrays.asList("mp3", "aac", "flac");
        List<String> imageTypes = Arrays.asList("jpg", "bmp", "gif");
        List<String> movieTypes = Arrays.asList("mp4", "avi", "mkv");

        String fileName;
        Integer fileSize;
        String fileExtension;
        FileType fileType;

        public File(String fileName, String fileSize) {
            this.fileName = fileName;
            this.fileSize = Integer.parseInt(removeLastChar(fileSize));
            String[] fileNameParts = fileName.split("\\.");
            fileExtension = fileNameParts[fileNameParts.length-1];
            fileType = findFileType();
        }

        private FileType findFileType(){
            FileType fileType;
            if (musicTypes.contains(fileExtension))
                fileType = FileType.MUSIC;
            else if (imageTypes.contains(fileExtension))
                fileType = FileType.IMAGE;
            else if (movieTypes.contains(fileExtension))
                fileType = FileType.MOVIE;
            else
                fileType = FileType.OTHER;
            return fileType;
        }

        private String removeLastChar(String str) {
            return str.substring(0, str.length() - 1);
        }
    }

    public String solution(String input){
        String[] fileLines = input.split(System.getProperty("line.separator"));
        List<File> files = new ArrayList<>();

        Map<FileType, Integer> fileSizeMap = new HashMap<>();
        fileSizeMap.put(FileType.IMAGE, 0);
        fileSizeMap.put(FileType.MUSIC, 0);
        fileSizeMap.put(FileType.MOVIE, 0);
        fileSizeMap.put(FileType.OTHER, 0);

        // parse input
        for (String line : fileLines){
            String[] lineValue = line.split(" ");
            files.add(new File(lineValue[0], lineValue[1]));
        }

        for (File file: files) {
            Integer currentSize = fileSizeMap.get(file.fileType);
            fileSizeMap.put(file.fileType, currentSize + file.fileSize);
        }

        return fileSizeMap.toString();
    }

    public static void main (String[] args) {
        String input = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 1000b";
        String solution = new MediaCounter().solution(input);
        System.out.println(solution);
    }
}