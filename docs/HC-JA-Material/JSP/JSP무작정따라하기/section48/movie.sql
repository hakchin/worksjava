create table movie(
movie_no number(6),
title varchar2(40),
image varchar2(100),
grade varchar2(20),
time varchar2(10),
director varchar2(20),
actor1 varchar2(20),
actor2 varchar2(20),
actor3 varchar2(20),
story varchar2(4000)
);
create sequence seq_mv_no
increment by 1
start with 1
maxvalue 100000
cycle
nocache;


insert into movie values(
seq_mv_no.nextval,
'쉬리',
'poster/shiri.jpg',
'2',
'120분',
'pf0008',
'pf0001',
'pf0004',
'pf0007',
'국가 비밀정보기관 O.P의 특수비밀요원인 유중원과 동료요원 이장길은 그들에게 중요한 제보를 자청했던 무기밀매상 보스 임봉주가 저격당하자 특수8군단 소속의 저격수 이방희라는 것을 짐작한다. 임봉주의 배후를 조사하던 유중원과 이장길은 이방희가 국방과학기술연구소에서 개발한 신소재 액체폭탄 CTX를 확보하려 했던것을 알아낸다. 한편 북에서 침투한 박무영과 특수8군단의 요원은 군단사령부로 이송중이던 CTX를 탈취한다. 유중원과 이장길이 뒤쫓지만 가까스로 목숨만 구한다. 이들의 움직임에 한발 앞서 나타나는 이방희 행적은 O.P 내부에 첩자가 있음을 짐작케하고 서로를 의심하는 상황이 된다. 도저히 방향을 종잡을 수 없는 상황 속에서 한달앞으로 다가온 명현과의 결혼은 유중원에게 또다른 불행을 예고한다. 단 한 번도 사랑한다는 말을 전하지 못한 채 자신의 신분을 감추고 명현을 대했던 유중현. 처음이자 마지막으로 이번일이 끝나면 꼭 같이 여행을 떠나자는 약속만을 남긴채, 명현을 뒤로하고 이방희의 행적을 뒤쫓는다. 마침내, 유중원은 고국장과 이장길에게까지 거짓 정보를 흘리고 독자적인 작전을 개시하는데... '
);
commit;



insert into movie values(
seq_mv_no.nextval,
'친구',
'poster/friend.jpg',
'3',
'115분',
'pf0010',
'pf0006',
'pf0003',
' ',
'폭력조직의 두목을 아버지로 둔 준석, 가난한 장의사의 아들 동수, 화목한 가정에서 티없이 자란 상택, 밀수업자를 부모님으로 둔 귀여운 감초 중호. 넷은 어딜 가든 함께 했다. 훔친 플레이보이지를 보며 함께 낄낄거렸고, 이소룡의 브로마이드를 보며 경쟁하듯 흉내냈고, 조오련과 바다 거북이 중 누가 더 빠를까하며 입싸움을 벌이기도 했다. 그때는 세상이 온통 푸르게만 보였다. 여드름이 금새라도 터질 것 같던 18세. 큰형처럼 친구들을 다독거려주는 준석, 준석에게 열등감을 가진 동수, 전교 1, 2등 자리를 다투던 상택, 촐싹대지만 없으면 심심한 중호. 어느 날, 근처 여고의 그룹사운드 레인보우의 공연을 보러가고, 그곳에서 상택과 준석은 싱어 진숙에게 홀딱 반한다. 상택의 마음을 안 준석은 일부러 상택과 진숙을 만나게 해준다. 중호와 상택은 대학에 진학했다. 둘은 대학생이 된 이후 연락이 끊겼었던 준석과 동수를 찾아갔다. 동수는 어찌된 이유인지 감옥에 수감돼 있었고, 준석은 어머니를 여읜 충격으로 마약에 깊이 빠져있었다. 그리고 상택이 태어나 처음으로 사랑했던 여자 진숙이 준석의 곁에 있었다. 그들의 20대는 이렇게 시작되었다. 아버지를 여의고 부친의 조직내 행동대장이 된 준석, 준석을 배신하고 새로운 조직의 행동대장이 된 동수, 미국 유학을 앞둔 상택, 결혼하여 횟집 주인장이 된 중호녀석... 상택은 유학길에 오르기 전, 친구들이 보고 싶어졌다. 끝내 준석과 동수는 공항에 나타나지 않았다. 친구들을 부산땅에 남기고 떠나는 상택은 웬지 불길한 예감이 드는데.... '
);
commit;


insert into movie values(
seq_mv_no.nextval,
'공동경비구역 JSA',
'poster/jsa.jpg',
'2',
'110분',
'pf0009',
'pf0002',
'pf0004',
'pf0005',
'여덟발의 총성! 진실은 그곳에 있다. 분단의 상징적 공간, 판문점 공동경비구역...돌아오지 않는 다리 북단 북측 초소에서 격렬한 총성이 울려퍼진다. 살인 사건이다. 어린 북한 초소병이 살해되었고, 그옆엔 중년의 북한 상위도 쓰러져 있다. 그리고 남북분계선 한가운데에 이 사건의 용의자이자 총상을 입은 젊은 남한 병사가 발견된다. 군사 분계선을 넘은 남한 병사에 의해 기습 테러 공격을 당했다. 초소 경계 근무 중에 군사 분계선을 넘어 침투한 북한군에 의해 납치. 감금되었던 남한 병사가 탈출하는 과정에서 총격적을 벌였다. 남과 북은 전혀 다른 주장을 펼치고, 남북 병사들은 서로 엇갈린 진술만 반복한다. 사건 수사를 맡은 중립국 여소령은 점차 진실에 다가간다. 이제부터 시작이다. 북한 초소병은 왜 살해되었을까? 최초 목격자인 또 한사람인 남한 병사는 왜 자살을 시도했을까? 살아남은 남한병사는 진실 앞에서 왜 침묵하고 있는가?'
);
commit;