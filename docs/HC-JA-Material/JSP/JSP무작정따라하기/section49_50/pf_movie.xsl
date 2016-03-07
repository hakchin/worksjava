<?xml version="1.0" encoding="euc-kr" ?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
    <xsl:template match="/">
      <html>
        <body>
          <h3 align="center">영화 설명</h3>
          <table align="center" border="0" width="600">
           <tr>
             <td height="200" width="150">
               <img width="150" height="200">
                 <xsl:attribute name="src">
                   <xsl:value-of select="list/movie/image"/>
                 </xsl:attribute>
               </img>
             </td>
               <td width="450">
                 제목 :<xsl:value-of select="list/movie/title_url"/>
                 <b><xsl:value-of select="list/movie/title"/></b>	
                 <br/><br/>
                 감독 :
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="list/movie/director_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="list/movie/director"/>
                 </xsl:element>
                 <br/><br/>
                 출연진 :
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="list/movie/actor1_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="list/movie/actor1"/>
                 </xsl:element>
                 <xsl:if test="list/movie/actor2[not(.='')]">	, </xsl:if>
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="list/movie/actor2_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="list/movie/actor2"/>
                 </xsl:element>
                 <xsl:if test="list/movie/actor3[not(.='')]"> , </xsl:if>
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="list/movie/actor3_url"/>
                   </xsl:attribute>
                  <xsl:value-of select="list/movie/actor3"/>
                </xsl:element>
                <br/><br/>
                상영시간 :<xsl:value-of select="list/movie/time"/>
                <br/><br/>
                등급 :
                <xsl:choose>
                  <xsl:when test="list/movie/grade[.=1]">미성년자 관람가</xsl:when>
                  <xsl:when test="list/movie/grade[.=2]">15세 이상 관람가</xsl:when>
                  <xsl:when test="list/movie/grade[.=3]">미성년자 관람불가</xsl:when>
                </xsl:choose>
              <br/>
            </td>
          </tr>
          <tr>
              <td colspan="2">줄거리</td>
          </tr>
          <tr>
            <td colspan="2"><xsl:value-of select="list/movie/story"/></td>
          </tr>
        </table>
        <p align="center"><a href="list_movie.jsp">목록으로..</a></p><br/>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

