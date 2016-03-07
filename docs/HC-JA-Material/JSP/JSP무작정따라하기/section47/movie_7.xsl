<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <p><li/> 
    <!-- 탐색기 루트에서 부터검색하는 단순한 절대 경로 감독의 이름을 표시 -->
    <xsl:value-of select="영화/쉬리/감독/이름"/>의 생일은
    <xsl:value-of select="영화/쉬리/감독/생일"/>입니다.<br/>
    </p>
    <p>
    <li/>
    <!-- 같은 이름의 태그들이 존재할 때 원하는 검색 방법__틀린 예 -->
    <xsl:value-of select="영화/쉬리/주연/이름"/>의 생일은 
    <xsl:value-of select="영화/쉬리/주연/생일"/>입니다.<br/>
    </p>
    <p>
    <li/>
    <!-- 같은 이름의 태그들이 존재할 때 원하는 검색 방법__옳은 예 -->
    <xsl:value-of select="영화/쉬리/주연/이름[.='송강호']"/>의 데뷔작은
    <xsl:value-of select="영화/쉬리/주연[이름='송강호']/데뷔작"/>입니다.<br/>
    </p>
    <p>   
    <!-- 속성값을 비교해서 특정 요소 내용을 가지고 오는 방법 [1]-->
    <li/>데뷔년도가 1995년인 배우들<br/>
    <xsl:for-each select="영화/쉬리/주연[데뷔작/@데뷔년도='1995']">
      <xsl:value-of select="이름"/> (<xsl:value-of select="데뷔작/@데뷔년도"/>년 데뷔)<br/>
    </xsl:for-each>
    </p>
    <p>
    <!-- 속성값을 비교해서 특정 요소 내용을 가지고 오는 방법 [2]-->
    <li/>데뷔년도가 1995년이 아닌 배우들<br/>
     <xsl:for-each select="영화/쉬리/주연[not(데뷔작/@데뷔년도='1995')]">
      <xsl:value-of select="이름"/> (<xsl:value-of select="데뷔작/@데뷔년도"/>년 데뷔)<br/>
    </xsl:for-each>
    </p>
  </xsl:template>
</xsl:stylesheet>

	
