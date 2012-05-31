<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="//CLIENTE">
		<xsl:value-of select="CLI_ID"/>,<xsl:value-of select="CLI_SAP"/>,<xsl:value-of select="CLASIFICACION_1"/>,<xsl:value-of select="CLASIFICACION_2"/>,<xsl:value-of select="CLASIFICACION_3"/>,<xsl:value-of select="ACCION_1"/>,<xsl:value-of select="ACCION_2"/>
	</xsl:template>
</xsl:stylesheet>





