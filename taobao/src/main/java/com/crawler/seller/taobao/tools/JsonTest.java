package com.crawler.seller.taobao.tools;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: taobao
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-23 14:44
 * @email: 630268696@qq.com
 **/
public class JsonTest {
    public static String testJson="{\n" +
            "        startTime        : +new Date,\n" +
            "        ver              : '7.19.19',\n" +
            "        st               : '',\n" +
            "        online           : true,\n" +
            "        shopVer          : 2,\n" +
            "        appId            : 1 ,\n" +
            "        itemId           : '585174273980',\n" +
            "        \n" +
            "        shopId           : '104897509',\n" +
            "        shopName         : '\\u62F3\\u5E087\\u4E03\\u53F7\\u6E38\\u620F\\u5916\\u8BBE\\u5E97',\n" +
            "        sellerId         : '143719062',\n" +
            "        sellerNick       : 'uruzu_7',\n" +
            "        sibUrl           : '//detailskip.taobao.com/service/getData/1/p1/item/detail/sib.htm?itemId=585174273980&sellerId=143719062&modules=dynStock,qrcode,viewer,price,duty,xmpPromotion,delivery,activity,fqg,zjys,couponActivity,soldQuantity,originalPrice,tradeContract',  \n" +
            "        descUrl          : location.protocol==='http:' ? '//dsc.taobaocdn.com/i2/580/170/585174273980/TB1nMYNzxTpK1RjSZFM8qvG_Vla.desc%7Cvar%5Edesc%3Bsign%5Edb3e3a289828ba0d5ae4c937ad932abe%3Blang%5Egbk%3Bt%5E1551679747' : '//desc.alicdn.com/i2/580/170/585174273980/TB1nMYNzxTpK1RjSZFM8qvG_Vla.desc%7Cvar%5Edesc%3Bsign%5Edb3e3a289828ba0d5ae4c937ad932abe%3Blang%5Egbk%3Bt%5E1551679747',  \n" +
            "        counterApi       : '//count.taobao.com/counter3?inc=ICVT_7_585174273980&sign=831737fd73dda034f17efe047d46b4e6c1701&keys=DFX_200_1_585174273980,ICVT_7_585174273980,ICCP_1_585174273980,SCCP_2_104897509',\n" +
            "        rateCounterApi   : '//rate.taobao.com/detailCount.do?itemId=585174273980',\n" +
            "        areaPrice        : false,\n" +
            "        \n" +
            "        lazyload         : '#J_DivItemDesc',\n" +
            "        \n" +
            "        tadComponetCdn   : true,\n" +
            "        delayInsurance   : false,\n" +
            "        fuwubao          : false,\n" +
            "        \n" +
            "        cdn              : true,\n" +
            "        sibFirst         : true,\n" +
            "        \n" +
            "        webp             : true,\n" +
            "        descWebP         : false,\n" +
            "        \n" +
            "        newDomain        : true,\n" +
            "        asyncStock       : true,\n" +
            "        enable           : true,\n" +
            "        \n" +
            "        m_ratio          : 20,\n" +
            "        \n" +
            "        beacon           : {},\n" +
            "        DyBase           : {\n" +
            "            iurl : '//item.taobao.com',\n" +
            "            purl : '//paimai.taobao.com',\n" +
            "            durl : '//siteadmin.taobao.com',\n" +
            "            lgurl: 'https://login.taobao.com/member/login.jhtml',\n" +
            "            surl : '//upload.taobao.com',\n" +
            "            suitUrl: '//jubao.taobao.com/index.htm?&spm=a1z6q.7847058&itemId='\n" +
            "        },\n" +
            "        idata            : {\n" +
            "            item: {\n" +
            "                id               : '585174273980',\n" +
            "                title            : 'havit\\/\\u6D77\\u5A01\\u7279 I1.\\u84DD\\u7259\\u8033\\u673A\\u8D85\\u957F\\u5F85\\u673A\\u8FF7\\u4F60\\u8D85\\u5C0F\\u8FD0\\u52A8\\u65E0\\u7EBF',\n" +
            "                pic              : '//gd1.alicdn.com/imgextra/i2/143719062/O1CN01gH1OKH2GoRdfRnYvX_!!143719062.jpg',\n" +
            "                price            : '',\n" +
            "                status           : 0,\n" +
            "                sellerNick       : 'uruzu_7',\n" +
            "                sellerNickGBK    : 'uruzu_7',\n" +
            "                skuComponentFirst: 'true',\n" +
            "                \n" +
            "                rcid             : '50011972',\n" +
            "                cid              : '50005050',\n" +
            "                virtQuantity     : '',\n" +
            "                holdQuantity     : '',\n" +
            "                \n" +
            "                quickAdd         : 1,\n" +
            "                \n" +
            "                edit             : true, \n" +
            "                \n" +
            "                initSizeJs:false,\n" +
            "                auto: '',\n" +
            "                \n" +
            "                bnow             : true,\n" +
            "                chong: false,\n" +
            "                \n" +
            "                dbst             : 1546393150000,\n" +
            "                stepdata         : {\n" +
            "                    \n" +
            "                },\n" +
            "                xjcc: false,\n" +
            "                \n" +
            "                type             : '',\n" +
            "                customHeader     : false,\n" +
            "                \n" +
            "                disableAddToCart  : !true,\n" +
            "                \n" +
            "                auctionImages    : [\"//gd3.alicdn.com/imgextra/i2/143719062/O1CN01gH1OKH2GoRdfRnYvX_!!143719062.jpg\",\"//gd3.alicdn.com/imgextra/i3/143719062/O1CN01sxs1kj2GoRdd9Ot41_!!143719062.jpg\",\"//gd2.alicdn.com/imgextra/i2/143719062/O1CN01PQKWZN2GoRdd552XB_!!143719062.jpg\",\"//gd4.alicdn.com/imgextra/i4/143719062/O1CN01NFkNQg2GoRdd59OqW_!!143719062.jpg\",\"//gd4.alicdn.com/imgextra/i4/143719062/O1CN01aGmKrU2GoRdewr0C0_!!143719062.jpg\"]\n" +
            "                \n" +
            "            },\n" +
            "            seller: {\n" +
            "                id          : '143719062',\n" +
            "                mode        : 0,\n" +
            "                shopAge     : '5'\n" +
            "                ,status      : 0\n" +
            "                ,goldSeller  : true\n" +
            "                \n" +
            "            },\n" +
            "            shop  : {\n" +
            "            \n" +
            "                id  : '104897509',\n" +
            "                url : '//lol7m.taobao.com/'\n" +
            "                \n" +
            "                ,pid: 255952820\n" +
            "                \n" +
            "                ,sid: 4\n" +
            "                \n" +
            "                ,xshop: true\n" +
            "                \n" +
            "                ,instId: 148052262\n" +
            "                \n" +
            "            \n" +
            "            }\n" +
            "        },\n" +
            "        vdata :{\n" +
            "        }\n" +
            "        \n" +
            "    }";

    public static void main(String[]args){
        JSONObject jsonObject = JSONObject.parseObject(testJson);
    }
}
