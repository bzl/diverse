<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Kurs ved UiB</h2>
    <xsl:for-each select="UIB/FAG">
    <table border="1">
      <tr>
        <th style="text-align:left">Fagkode</th>
        <td><xsl:value-of select="FAGKODE"/></td>
      </tr>
      
      <tr>
        <th style="text-align:left">Navn</th>
        <td><xsl:value-of select="TITTEL"/></td>
      </tr>

      <tr>
        <th style="text-align:left">Studiepoeng</th>
        <td><xsl:value-of select="STUDIEPOENG"/></td>
      </tr>

      <tr>
        <th style="text-align:left">Undervisingssemester</th>
        <td><xsl:value-of select="Undervisingssemester"/></td>
      </tr>

      <tr>
        <th style="text-align:left">Fakultet</th>
        <td><xsl:value-of select="Fakultet"/></td>
      </tr>
      
    </table>
	<br/>
    </xsl:for-each>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

