package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();
	
	public int addList(Music music) {
		// 마지막 리스트에 객체 저장, 1 리턴
		boolean check = list.add(music);
		int result = check ? 1 : 0;
		return result;
	}
	
	public int addAtZero(Music music) {
		// 첫 번째 리스트에 객체 저장, 1 리턴
		list.add(0, music);
		int result = list.contains(music) ? 1 : 0;
		return result;
	}
	
	public List<Music> printAll() {
		// List 반환
		return list;
	}
	
	public Music searchMusic(String title) {
		// 곡명으로 객체 검색, 객체가 있으면 객체 정보 리턴, 없으면 null 리턴
		for(int i = 0; i < list.size(); i++) {
			Music music = list.get(i);
			if(title.equals(music.getTitle())) {
				return music;
			} else {
				
			}
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		// 곡명으로 객체 검색, 객체가 있으면 객체 정보 삭제, 없으면 null 리턴
		for(int i = 0; i < list.size(); i++) {
			Music music = list.get(i);
			if(title.equals(music.getTitle())) {
				return list.remove(i);
			}
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		// 곡명으로 객체 검색, 객체가 있으면 객체 정보 수정, 없으면 null 리턴
		for(int i = 0; i < list.size(); i++) {
			Music setMusic = list.get(i);
			if(title.equals(setMusic.getTitle())) {
				return list.set(i, music);
			}
		}
		return null;
	}
	
	public int ascTitle() {
		// 리스트 곡명 오름차순 정렬, 제목이 같으면 가수명으로 오름차순 정렬, 1 리턴
//		list.sort(new AscTitle()); // AscTitle 기준으로 정렬
		Collections.sort(list, new AscTitle());
		return 1;
	}
	
	public int descSinger() {
		// 리스트 가수명 내림차순 정렬, 1 리턴
		Collections.sort(list);
		return -1;
	}
}
