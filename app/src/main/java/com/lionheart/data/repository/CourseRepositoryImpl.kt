package com.lionheart.data.repository

import com.lionheart.domain.entity.Course
import com.lionheart.domain.entity.WeeklyCourse
import com.lionheart.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
//    private val courseDataSource: CourseDataSource
) : CourseRepository {
    override suspend fun getCourseWeekly(): List<Course> = listOf(
        Course.asMonth(2),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                4,
                "아빠가 되기 위한 9개월 로드맵",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "4주차에는 처음 부모가 된 예비 아빠들을 위해 출산의 전반적인 로드맵을 다룰 예정이에요. 개인병원과 종합병원 중 어떤 곳을 선택해야 할까요? 출산 예정일은 어떻게 계산할까요? 아빠가 되기 위한 첫 걸음을 함께해보세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                5,
                "산부인과 첫 진료에 대한 모든 것",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "5주차에는 산부인과가 조금은 낯선 아빠들을 위해 첫 번째 진료에 대한 아티클을 준비했어요. 산모 수첩은 무엇이고, 초음파 사진은 어떻게 해석해야 할까요? 흥미로운 태몽 이야기와 마인드컨트롤 방법까지, 차근차근 아빠가 될 공부를 시작해요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                6,
                "입덧의 시작과 임신 바우처 신청",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/6%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "6주차에는 임신 초기 단계의 가장 커다란 고비, 입덧에 대한 이야기를 전해드려요. 먹덧, 토덧, 체덧 ⋯ 입덧에도 여러 종류가 있다는 사실을 알고 계셨나요? 더불어 200만원의 임신 바우처와 무료 보건소 혜택까지 꼼꼼하게 준비했으니, 놓치지 마세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                7,
                "아기의 심장소리가 주는 힘과 태아 보험",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/7%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "7주차가 되면 아기의 심장소리를 들을 수 있어요. 유산, 조산 등에 대비해 본격적으로 태아보험을 알아보면서, 엄마의 몸과 마음에 찾아온 다양한 변화를 체크해요. 아기를 낳은 후에도 건강한 모습을 유지할 수 있도록 아빠가 먼저 노력해볼까요?"
            )
        ),

        Course.asMonth(3),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                8,
                "입덧과 변비를 슬기롭게 해결하는 법",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "8주차에는 계속되는 입덧과 변비, 정맥류 등 임신부의 신체적 변화를 다룰 예정이에요. 체력과 면역력이 약해진 엄마를 위한 식단표와 컨디션을 회복할 수 있도록 부부가 함께 즐길 수 있는 운동 리스트를 준비했어요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                9,
                "임신의 불편한 손님, 산전 우울증",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "9주차에는 뛰어난 공감 능력으로 입덧을 경험하는 '쿠바드 증후군'에 대한 아티클을 준비했어요. 더하여 환경과 호르몬의 변화로 자연스레 찾아온 산전 우울증 이야기를 전해드려요. 산전 우울증은 아빠의 노력으로 함께 해결할 수 있어요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                10,
                "임신 초기, 산전 검사 완전 정복",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/10%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "10주차에는 임신 초기에 필요한 산전 검사를 총정리할 예정이에요. 천재 소년 '송유근'을 키운 아버지의 특별한 태교 이야기부터 임신부에게 좋은 비타민, 워킹대디라면 반드시 알아두어야 할 출산 휴가 관련 정책까지, 꼼꼼히 체크해보세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                11,
                "아빠가 반드시 기억해야 할 엄마의 변화들",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/11%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "11주차에는 치질과 속쓰림, 흑선, 임신성 간지러움 등 임신 3개월차에 나타나는 불편한 변화를 다룰 예정이에요. 와이프의 힘든 마음을 이해하기 위한 노력, 부부가 함께 수강할 수 있는 산모 교실과 프로그램을 추천해드려요."
            )
        ),

        Course.asMonth(4),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                12,
                "다운증후군 선별 검사와 유전 이야기",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/12%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "12주차에는 다운증후군 선별 검사를 진행하는데, 고위험군일 경우 융모막 검사가 필요해요. 확률일 뿐이지만 예비 부모들을 정말 가슴 졸이게 하는 유전 질환 검사, 제대로 알고 똑부러지게 준비해볼까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                13,
                "무료 출산 선물과 임신부 편의 용품",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/13%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "13주차에는 예비 부모들이 챙겨갈 수 있는 무료 출산 선물과 다양한 지원 물품에 대한 이야기를 전해드려요. 잇몸이 약해진 임신부를 위한 전용 칫솔을 알고 계신가요? 출산 준비도 아이템전, 임신부 편의 용품을 알려드려요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                14,
                "아기가 소리를 듣기 시작해요",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/14%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "14주차부터 뱃속의 아기가 바깥의 소리를 듣기 시작해요. 아빠의 목소리를 아기에게 편안하게 들려줄 수 있도록 '태담'에 대한 아티클을 준비했어요. 더불어 예비 부모라면 반드시 챙겨야할 임신, 출산, 육아 박람회에 대한 정보도 놓치지마세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                15,
                "부부만의 시간이 필요한 이유",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/15%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "15주차는 입덧과 유산의 위험이 줄어든 안정기로, 태교 여행을 계획하고 있다면 가장 적합한 시기라고 할 수 있어요. 아기가 태어나기 전 부부만의 시간이 꼭 필요하다는 것을 잊지 말기! 다른 아빠들의 태교 여행 이야기를 전해드려요."
            )
        ),

        Course.asMonth(5),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                16,
                "작은 노력으로도 좋은 아빠가 되는 팁",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/16%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "16주차에는 많은 돈과 시간을 들이지 않고 와이프를 감동시킬 수 있는 소소한 팁을 공유해요. 임신부를 위한 따뜻한 족욕부터 앉아서도 가볍게 할 수 있는 스트레칭까지, 좋은 아빠가 되기 위해 좋은 남편이 되어볼까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                17,
                "아기의 성별을 확인할 수 있어요",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/17%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "17주차에는 아기의 성별을 확인할 수 있어요. 임신 초기에 성별을 파악하기 위해 초음파 사진을 요리조리 돌려보는 '각도법'이 유행하기도 했지만, 사실 정확한 성별은 17주차 이후에 산부인과에서 검사를 통해 알 수 있답니다."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                18,
                "태동의 시작, 아기와 교감하기",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/18%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "18주차부터는 태동이 시작되어 아기의 움직임을 직접 느낄 수 있어요. 배 위에 가만히 손을 얹고 아기와 교감을 시도할 수 있는 방법을 전해드려요. 더불어, 배우자와 함께 육아에 대한 가치관을 공유해보세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                19,
                "출산 용품, 지금 시작해도 늦지 않아요",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/19%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "19주차에는 다양한 출산 용품을 준비하기 위한 전반적인 전략을 다룰 예정이에요. 육아 프리미엄이 점차 확대되는 세상, 정말 필요한 물건만 합리적인 가격에 구입하는 방법은 없을까요?"
            )
        ),

        Course.asMonth(6),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                20,
                "정밀 초음파 검사를 한다면 바로 지금",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/20%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "20주차에는 정밀 초음파 검사에 대한 아티클을 준비했어요. 아기의 크기와 초음파의 해상력, 발달 상태를 모두 고려해보았을 때, 아기의 모습을 초음파로 남길 수 있는 가장 적절한 시기랍니다."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                21,
                "몸무게로 임신부의 건강을 확인하는 법",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/21%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "21주차에는 몸무게로 임신부의 건강을 확인하는 방법을 전해드려요. 임신했으니 무조건 잘 먹어야 할까요? No! 영양상 균형이 고르게 맞춰진 식단을 기반으로 담백한 음식을 '적당히' 먹는 것이 중요해요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                22,
                "롤러코스터를 타는 엄마의 기분",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/22%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "22주차에는 롤러코스터를 타듯, 하루에도 수십번씩 요동치는 예비 엄마의 기분을 여러 케이스로 정리해봤어요. 임신부의 기분이 자주 변하는 건, 호르몬의 영향이랍니다. 슬기롭게 컨디션 난조를 극복하는 방법을 찾아볼까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                23,
                "부부가 함께 듣는 분만 예비 교실",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/23%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "23주차에는 부부가 함께 듣는 분만 예비 교실에 대한 아티클을 준비했어요. 어느덧 임신 6개월차, 분만이 두렵게만 느껴진다면? 몸이 더 무거워지기 전에 직접 들어보면 좋을 교육 프로그램을 추천해드려요."
            )
        ),

        Course.asMonth(7),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                24,
                "임신성 당뇨병을 주의하세요",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/24%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "24주차에는 임신 중기에 찾아오는 불청객, 임신성 당뇨병을 다룰 예정이에요. 임신부 100명 중 5명 정도는 임신성 당뇨병을 앓고 있을 정도로 꽤나 치명적인 입신 합병증, 슬기롭게 예방하는 방법을 전해드려요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                25,
                "산후조리 계획 점검",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/25%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "25주차에는 본격적으로 산후조리 계획을 점검할 수 있도록 가이드라인을 제공해요. 다양한 프로그램과 24시간 신생아 간호사가 상주하는 산후조리원? 합리적인 가격으로 편안한 집에서 안전하게 몸을 회복할 수 있는 산후도우미?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                26,
                "엄마가 웃으면 아기도 웃는다",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/26%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "26주차부터는 아기가 엄마의 감정을 비슷하게 느낄 수 있어요. 엄마가 행복하게 웃으면 아기도 미소를 짓고, 반대로 엄마가 화눈물을 흘리면 아기도 불안한 감정을 느껴요. 감정적으로 건강한 환경을 만드는 방법을 함께 찾아볼까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                27,
                "출산 전후 휴가, 미리 신청하세요",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/27%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "27주차에는 분만에 대한 계획을 세우면서, 출산 전후 휴가와 관련한 지원 제도를 다룰 예정이에요. 출산 예정일보다 늦게 아기를 낳게 된다면 휴가도 미룰 수 있을까요? 주말에 아기를 만난다면 휴가를 쓸 수 없는 걸까요?"
            )
        ),

        Course.asMonth(8),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                28,
                "자연분만과 제왕절개에 대하여",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/28%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "28주차에는 후회없는 선택을 할 수 있도록 분만에 대한 자세한 아티클을 준비했어요. 자연분만과 제왕절개는 정답이 존재하지 않는 문제라고 할 수 있어요. 하지만 선택권은 타인이 아니라 오직 예비 부모에게만 있다는 것을 기억해요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                29,
                "아기방 꾸미기 대작전",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/29%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "29주차에는 아기를 만나기 전 집안 곳곳을 청소하고, 아기를 맞을 준비를 해요. 신생아는 태열이 있기 떄문에 방의 적정 온도가 어른과 다르다는 사실을 알고 계셨나요? 아기의 방은 무조건 조용하기만 해야 할까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                30,
                "출산 계획표, 플랜 B까지",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/30%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "30주차에는 본격적인 분만에 앞서, 부부가 함께 출산 계획표를 만들어가는 시간을 가질 수 있도록 관련된 아티클을 준비했어요. 분만이 진행되다보면 예측할 수 없는 변수들이 발생하기 때문에, 플랜 B까지 고민해보시기를 추천드려요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                31,
                "미리 배우는 아기 목욕 방법",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/31%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "31주차에는 아기가 태어난 후 모든 것들이 조심스럽고 걱정되는 예비 부모들을 위해 아기 목욕 방법을 미리 알려드려요. 부부가 함께 직접 아기 목욕 방법을 배우고 경험할 수 있는 분만 교실과 관련된 정보들도 준비했어요."
            )
        ),

        Course.asMonth(9),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                32,
                "무급? 유급? 육아 휴직의 모든 것",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/32%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "32주차에는 육아 휴직에 대한 제도와 지원을 차근차근 전해드려요. 나라에서는 아빠들도 육아 휴직을 활용하도록 권장하고 있지만, 걱정되는 마음은 당연해요. 실제로 아기가 태어난 후 육아 휴직을 신청했던 다른 아빠들의 이야기를 담았어요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                33,
                "출산 후 하루 일과를 미리 그려보기",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/33%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "33주차에는 출산 후 일상을 미리 그려보고 준비할 수 있도록 신생아를 데리고 집에 온 예비 부모들의 하루 일과를 전해드려요. 병원에서 돌아오면 몇 시에 자고, 어떤 일들을 하게 될까요? 그 중에서도 가장 힘들고 고된 부분은 무엇일까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                34,
                "부부가 온전히 보내는 마지막 시간",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/34%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "34주차에는 새로운 가족을 만나기 전 부부가 함께 보내는 마지막 시간을 온전히 즐길 수 있도록 관련된 아티클을 준비했어요. 아기가 태어나면 다시 느낄 수 없을, 둘만의 여유롭고 잔잔한 일상을 즐겨보세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                35,
                "출산 가방 준비하기",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/35%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "35주차에는 언제든지 병원에 갈 수 있도록 출산 가방을 준비하는 방법을 전해드려요. 혹시라도 양수가 터지거나 급하게 출산을 진행해야 하는 경우, 엄마가 아무 걱정 없이 병원에 갈 수 있도록 아빠는 출산에 필요한 것들을 미리 챙겨주세요."
            )
        ),

        Course.asMonth(10),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                36,
                "임신 마지막달, 정밀 초음파 검사",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/36%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "36주차부터는 임신 마지막 달에 접어들면서 매주 산부인과를 방문해요. 정밀 초음파 검사를 통해 아기가 잘 자라고 있는지, 태어날 준비를 하고 있는지 체크해요. 이때부터는 엄마가 거동에 불편함을 느끼기 때문에, 함께 병원에 방문해주세요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                37,
                "아빠는 분만실에 무조건 들어가야 할까",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/37%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "37주차에는 본격적으로 분만에 대한 작은 부분까지 체크하고 배우자와 미리 상의할 수 있도록 아티클을 준비했어요. 아빠는 무조건 분만실에 들어가야 할까요? 다른 아빠들은 어떤 고민을 하고 있는지 생생한 이야기를 들려드릴게요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                38,
                "해줄 수 있는 게 없어 초조하다면",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/38%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "38주차에는 분만 과정에서 도움이 될 수 있는 아빠의 소소한 팁을 정리했어요. 진통은 짧게는 2시간, 길게는 이틀을 넘어가기도 해요. 엄마가 진통을 느끼는 순간에 아빠는 어떻게 해야 할까요? 밥을 먹고 와도 될까요?"
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                39,
                "좋은 아빠가 될 용기",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/39%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "39주차는 아기를 만나게 되더라도 더이상 위험하지 않은 시기입니다. 그동안 수없이 상상해왔던 순간이 드디어 가까워지고 있어요. 마냥 설레고 두근거리기만 하지 않아도 괜찮아요. 좋은 아빠가 된다는 건, 생각보다 큰 용기가 필요하거든요."
            )
        ),
        Course.asWeek(
            WeeklyCourse.WeeklyCourseData(
                40,
                "아기가 태어난 후 벌어지는 일",
                "https://lionheart-article-s3.s3.ap-northeast-2.amazonaws.com/images/curriculum/40%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1.png",
                "40주차는 아기가 태어난 후 해결해야 할 일들을 정리했어요. 아기의 출생신고는 언제까지 어떻게 해야 할까요? 아기를 데리고 집에 온 순간, 열이 나기 시작한다면 어떻게 해야 할까요? 걱정은 접어두고, 차근차근 준비해봅시다."
            )
        ),
    )

}