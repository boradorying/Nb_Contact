# 프로젝트 제목

**연락처앱**

## 프로젝트 설명 및 목적

이 프로젝트는 당근마켓을 클론코딩하여 다음과 같은 목표를 가지고 진행되었습니다:
- 즐겨찾기 여부에 따라 두가지 VIEW TYPE를 사용해 사용자에게 두가지 뷰타입을 보이게합니다
- 전화걸기 아이콘을 클릭하면 해당전화번호로 전화걸 수 있게 가능합니다



## 구체적인 설명

### 1. 두가지 뷰타입 페이지


![0830113820408670](https://github.com/boradorying/Nb_Contact/assets/136980408/07b9ef9a-5abe-4839-8902-2402e21ea4ea)

- 리싸이클러뷰에 즐겨찾기 여부에 따라 달라질 두가 뷰타입의 아이템 xml 입니다 
- 즐겨찾기 여부에 따라서 두가지 뷰타입이 표시됩니다 boolean 을 사용해 사용자들 기본값을 false로 설정 어떤게 추가될지 모르니 동적으로 표시하기 위해서

### 2. data class에 bookmark를 boolean을 추가해서 즐겨찾기 버튼 클릭시 if문을 통해서 두가지 뷰타입표시

![0830114040608876](https://github.com/boradorying/Nb_Contact/assets/136980408/39e3faf7-92fa-4687-9d88-25f601be2ed7)


- 어댑터에서 override fun getItemViewType(position: Int): Int {//뷰타입 결정
        return if (profiles[position].bookmark) {
            VIEW_TYPE_BOOKMARKED
        } else {
            VIEW_TYPE_NORMAL
        }
    } 을 이용해서 북마크 클릭여부에 따라 뷰타입 다르게 표시


### 3.전화 아이콘 클릭했을 시 전화걸기(뷰타입에 따라 전화거는 함수,아이콘도 따로 추가해줌)
![0830114248837118](https://github.com/boradorying/Nb_Contact/assets/136980408/f6c508ea-7525-48a4-adc5-2982b6291f53)



- makePhoneCall 함수를 사용해 그 위치 포지션 아이템 클릭시 이벤트 추가



## 구현 동영상

프로젝트의 구현 내용을 시연하는 동영상을 아래 링크에서 확인하실 수 있습니다:
[프로젝트 시연 동영상](https://boradoritech-ai.tistory.com/47)

## 사용 기술 및 라이브러리

- **Android Kotlin**: 안드로이드 앱 개발에 사용되는 주요 프로그래밍 언어입니다.
- **RecyclerView**: 아이템 목록을 표시하기 위해 사용되며 효율적인 아이템 관리를 지원합니다.
- 
