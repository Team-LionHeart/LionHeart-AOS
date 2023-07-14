package com.lionheart.presentation.article

import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityArticleBinding
import com.lionheart.domain.entity.ArticleComponent
import com.lionheart.domain.entity.ArticleComponentType

class ArticleActivity : BindingActivity<ActivityArticleBinding>(R.layout.activity_article) {
    private lateinit var adaptor: ArticleAdaptor
    override fun constructLayout() {
        setAdaptor()
    }

    private fun setAdaptor() {
        adaptor = ArticleAdaptor()
        binding.rvArticleMain.adapter = adaptor
        adaptor.submitList(
            mutableListOf(
                ArticleComponent(ArticleComponentType.EDITOR_NOTE.id, "안녕하세요, 아기사자님!\n라이온하트에서 오늘은 출산카드와 관련된 이야기를 들려드리려고 해요."),
                ArticleComponent(ArticleComponentType.CHAPTER_TITLE.id, "Chater 1.\n아빠가 되는 시작,\n임신바우처 신청의 모든 것이\n궁금한 당신께"),
                ArticleComponent(
                    ArticleComponentType.BODY.id,
                    "농담처럼 이런 이야기를 들어보신 적 있으신가요?\n" +
                            "임신을 확인한 순간 가장 먼저 해야 할 일, 주변에 알리는 것보다 먼저 임신바우처 신청을 하라는 이야기가 있어요.\n\n\n" +
                            "임신 혜택 중 하나로 임신,출산 진료비 지원 신청을 하면 지원금을 받게 되는데요. 병원 진료비와 약값이 만만치 않은데 바우처 덕분에 임신 기간 동안 나름 유용하게 사용했던 혜택이 아닐까 싶어요.\n\n\n" +
                            "임신 1회당 단태아는 100만원, 다태아는 140만원의 금액을 지원받을 수 있다는 사실! 지금부터 라이온하트와 함께 알아볼까요?"
                ),
                ArticleComponent(ArticleComponentType.GENERAL_TITLE.id, "출산카드? 임신바우처를 알려드려요."),
                ArticleComponent(ArticleComponentType.BODY.id, "임신바우처는 임신과 출산에 관련된 비용을 지원해주는 국가바우처로, 지정된 은행이나 카드사에서 카드형태로 발급받을 수 있어요.", "* 2023년 7월을 기준으로 총 4개 카드사에서 발급받을 수 있어요!"),
                ArticleComponent(ArticleComponentType.BODY.id, "임신과 출산 시 진료비지원을 받을 수 있도록 정부에서 지원되는 바우처를 ‘임신바우처’라고 해요. 혹여나 유산이나 사산의 경우가 발생하더라도, 기존에 발급받은 임신바우처를 사용할 수 있어요.\n" +
                        "\n" +
                        "국민행복카드를 통해 바우처가 지급되고, 카드를 결제하면 잔액이 차감되는 형태로 사용이 가능해요. 지원기간은 출산일로부터 최대 2년까지 사용가능하며 유효기간 내 미사용시 포인트는 자동 소멸된다고 해요."),
                ArticleComponent(ArticleComponentType.GENERAL_TITLE.id, "우선, 임신 확인서가 필요해요."),
                ArticleComponent(ArticleComponentType.BODY.id, "산부인과에서 임신확인검사를 마치고 나면, 병원에서 임산부 등록을 진행해요. 이때 산부인과에 임산부 확인서를 요청할 수 있어요.\n" +
                        "\n" +
                        "보건소에서도 임산부 확인서를 발급받을 수 있어요! 간단한 개인정보 등을 작성하면 임산부 등록이 완료되는데, 이때 추가적으로 임신축하 선물도 함께 지급을 받을 수 있어요. \n" +
                        "\n" +
                        "모자보건 사업안내 책자, 엽산(3개월치), 철분(5개월치), 손수건, 배냇저고리, 임산부 뱃지가 들어 있는데, 특히 보건소에서 제공하는 엽산은 시중에 파는 것보다 함량이 높고 흡수가 잘되기 때문에 이것부터 복용하는 것이 좋다고 해요. 철분은 16주부터 먹으면 되는데, 출산후에도 계속해서 복용하는 것이 좋다고 하며, 임산부 뱃지는 가방에 달고 다니며 대중교통 이용할 때 도움을 받을 수 있어요!"),
                ArticleComponent(
                    ArticleComponentType.IMAGE.id,
                    "https://github.com/Team-Smeme/smeem-aos/assets/88091704/1ecf9ac6-7d3d-4478-ab09-7e55488d2b36",
                    "선환이 github image"
                ),
                ArticleComponent(ArticleComponentType.CHAPTER_TITLE.id, "Chater 2.\n" +
                        "더욱 편리하게 지원금을 사용하는 방법, 국민행복카드를 발급받아볼까요?"),
                ArticleComponent(ArticleComponentType.BODY.id, "국민행복카드를 발급받으면 각종 정부 지원금을 받을 수 있어요. 아이 한 명 당 100만 원을 지원받을 수 있답니다.\n" +
                        "\n" +
                        "국민행복카드는 기존에 가지고 있는 카드를 그대로 이용하는 방법과 신규 카드를 발급받는 방법이 있어요. 기존 카드를 그대로 이용할 경우 자신이 현재 이용하고 있는 카드사의 앱을 통해서 간단하게 발급이 가능해요. 기존 카드에 발급은 본인이 현재 쓰고 있는 카드사 앱을 통해 간단하게 발급 받을 수 있어요.\n" +
                        "\n" +
                        "국민행복카드는 신용카드와 체크카드 2종류가 있으며 국민, 신한, 삼성(신용카드만 가능), 롯데, 하나, IBK, 농협에서 발급받을 수 있어 혜택을 비교한 후 결정하시는 것이 이득이라고 할 수 있어요!\n" +
                        "\n" +
                        "연회비가 없고 카드사별 신용카드 혹은 체크카드의 혜택도 함께 받아볼 수 있다는 장점이 될 수 있어요.")

            )
        )
    }
}