package com.service.com.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class DummyData {

	private static Set<String> usedBoardIds = new HashSet<>();

	private static String generateBoardId(int counter) {
		return String.format("%04d", counter);
	}

	private static String generateInsertStatement(int counter) {
		String boardId;
		do {
			boardId = generateBoardId(counter);
		} while (usedBoardIds.contains(boardId));

		usedBoardIds.add(boardId);

		return String.format(
				"INSERT INTO `board` (`board_id`, `post_id`, `board_name`, `board_type`, `board_use_yn`, `attatch_file_yn`, `attach_file_num`, `reply_post_yn`, `post_passwd_yn`, `board_editor_yn`, `reg_date`, `mod_date`, `reg_id`, `mod_id`) "
						+ "VALUES ('%s', '%d', '게시판%d', 'A', 'Y', 'Y', 2, 'Y', 'N', 'Y', '2023-11-30 10:00:00', '2023-11-30 10:30:00', 'admin', 'admin');",
				boardId, 100 + counter, counter);
	}
	
    private static final String[] TITLES = {
            "안녕하세요!", "자유게시판입니다.", "좋은 정보 공유해요.", "질문이 있어요.", "즐거운 주말 되세요!",
            "오늘의 일기", "IT 소식", "자바 프로그래밍", "스포츠 이야기", "맛집 추천",
            "책 읽고 나누기", "음악 감상", "영화 추천", "여행 이야기", "취미 생활"
    };

    private static final String[] CONTENTS = {
            "내용입니다.", "잘 부탁드립니다.", "토론 자유", "어떻게 생각하시나요?", "참여해주세요!",
            "많이 읽어주세요.", "맛있게 먹었습니다.", "추천해요!", "이런 책을 읽었어요.", "같이 갈 사람 구해요."
    };

    private static final String[] PASSWORDS = {
            "password1", "secret", "1234", "password123", "securepw"
    };

    private static String generatePostId(int counter) {
        return String.format("%04d", counter);
    }

    private static String getRandomTitle() {
        return TITLES[new Random().nextInt(TITLES.length)];
    }

    private static String getRandomContent() {
        return CONTENTS[new Random().nextInt(CONTENTS.length)];
    }

    private static String getRandomPassword() {
        return PASSWORDS[new Random().nextInt(PASSWORDS.length)];
    }

    private static String generatePostInsertStatement(int counter) {
        return String.format("INSERT INTO `post` (`post_id`, `post_title`, `post_content`, `post_passwd`, `post_parent_id`, `post_read_cnt`, `reg_date`, `reg_id`, `mod_id`) " +
                        "VALUES ('%s', '%s', '%s', '%s', NULL, %d, NOW(), 'admin', NULL);",
                generatePostId(counter), getRandomTitle(), getRandomContent(), getRandomPassword(), ThreadLocalRandom.current().nextInt(1, 101));
    }

	
	

	public static void boarddummydata() {
		for (int i = 1; i <= 40; i++) {
			String query = generateInsertStatement(i);
			System.out.println(query);
		}
	}
	
	public static void postdummydata() {
		for (int i = 1; i <= 40; i++) {
			String query = generatePostInsertStatement(i);
			System.out.println(query);
		}
	}
	
	
	public static void dummyData() 
	{
		boarddummydata();
		postdummydata();
		
	}
	

}
