package com.keebraa.license.docs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.keebraa.license.docs.stubs.BaseDocumentStub;

public class ComplaintDocumentTest
{
    @Test
    public void testAddTextLineToEmptyText() throws Exception
    {
        ComplaintDocument sut = getComplaintDocument();

        assertEquals("", sut.getText());

        sut.addTextLine("some text");
        sut.addTextLine("some another text");

        String expected = "some text" + System.getProperty("line.separator") + "some another text";
        assertNotNull(sut.getText());
        assertEquals(expected, sut.getText());
    }

    @Test
    public void testAddTextLineToFilledText() throws Exception
    {
        ComplaintDocument sut = getComplaintDocument();

        assertEquals("", sut.getText());
        sut.setText("filled");
        sut.addTextLine("some text");
        sut.addTextLine("some another text");

        String expected = "filled" + System.getProperty("line.separator") + "some text"
            + System.getProperty("line.separator") + "some another text";
        assertNotNull(sut.getText());
        assertEquals(expected, sut.getText());
    }

    @Test
    public void testAppendText() throws Exception
    {
        ComplaintDocument sut = getComplaintDocument();

        assertEquals("", sut.getText());

        sut.setText("some text");
        sut.addText("some another text");

        assertNotNull(sut.getText());
        assertEquals("some textsome another text", sut.getText());
    }

    @Test
    public void testSetText() throws Exception
    {

        ComplaintDocument sut = getComplaintDocument();

        assertEquals("", sut.getText());

        sut.setText("some text");

        assertNotNull(sut.getText());
        assertEquals("some text", sut.getText());
    }

    private ComplaintDocument getComplaintDocument() throws Exception
    {
        InspectionDocument inspDocument = new InspectionDocument(new BaseDocumentStub());
        ReportDocument reportDocument = new ReportDocument(inspDocument);
        DisposalDocument dispDocument = new DisposalDocument(reportDocument);
        ComplaintDocument complaintDocument = new ComplaintDocument(dispDocument);
        return complaintDocument;
    }
}
