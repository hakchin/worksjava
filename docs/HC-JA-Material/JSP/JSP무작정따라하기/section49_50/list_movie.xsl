<?xml version="1.0" encoding="euc-kr" ?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">	
   <xsl:template match="/">
      <html>
        <body>
          <h3 align="center">영화 목록</h3>					
          <xsl:for-each select="list/movie">
            <table align="center" border="1" width="500">
              <tr>
                <td align="center" colspan="4">
                  <xsl:element name="a">
                    <xsl:attribute name="href">
                      <xsl:value-of select="title_url"/>
                    </xsl:attribute>
                    <b><xsl:value-of select="title"/></b>
                  </xsl:element>
                </td>
              </tr>
              <tr>
                <td align="center">감독 </td>
                <td colspan="3">
                  <xsl:element name="a">
                    <xsl:attribute name="href">
                      <xsl:value-of select="director_url"/>
                    </xsl:attribute>
                    <xsl:value-of select="director"/>
                  </xsl:element>
                </td>
              </tr>
             <tr>
               <td>출연진</td>
               <td colspan="3">
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="actor1_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="actor1"/>
                 </xsl:element>
                 <xsl:if test="actor2[not(.='')]"> , </xsl:if>
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="actor2_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="actor2"/>
                 </xsl:element>
                 <xsl:if test="actor3[not(.='')]"> , 	</xsl:if>
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="actor3_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="actor3"/>
                 </xsl:element>
               </td>
             </tr>
             <tr>
               <td>상영시간</td>
               <td><xsl:value-of select="time"/></td>
               <td>등급</td>
               <td>
                 <xsl:choose>
                   <xsl:when test="grade[.=1]">미성년자 관람가</xsl:when>
                   <xsl:when test="grade[.=2]">15세 이상 관람가</xsl:when>
                   <xsl:when test="grade[.=3]">미성년자 관람불가</xsl:when>
                 </xsl:choose>
               </td></tr>
             </table>
             <br/>
           </xsl:for-each>
         </body>
       </html>
    </xsl:template>
  </xsl:stylesheet>
