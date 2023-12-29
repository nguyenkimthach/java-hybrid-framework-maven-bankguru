package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.bankguru.ManagePageUI;

public class ManagePageObject extends BasePage {
	WebDriver driver;

	public ManagePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isManagerPageMessageDiplayedByText(String message) {
		waitForElementVisible(ManagePageUI.MANAGER_PAGE_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(ManagePageUI.MANAGER_PAGE_MESSAGE_BY_TEXT, message);
	}

	@Step("click To Avertiment dismiss Button")
	public void clickToAvertimentDismissButton() {
		if (!isElementUndisplayed(ManagePageUI.ADVERTISEMENT_IFRAME)) {
			switchToFrameIframe(ManagePageUI.ADVERTISEMENT_IFRAME);

			if (!isElementUndisplayed(ManagePageUI.ADVERTISEMENT_SUB_IFRAME)) {
				switchToFrameIframe(ManagePageUI.ADVERTISEMENT_SUB_IFRAME);
				waitForElementClickable(ManagePageUI.ADVERTISEMENT_DISMISS_BUTTON);
				clickToElement(ManagePageUI.ADVERTISEMENT_DISMISS_BUTTON);
				switchToParentFrame();
			} else if (!isElementUndisplayed(ManagePageUI.ADVERTISEMENT_DISMISS_BUTTON)) {
				waitForElementClickable(ManagePageUI.ADVERTISEMENT_DISMISS_BUTTON);
				clickToElement(ManagePageUI.ADVERTISEMENT_DISMISS_BUTTON);
			}
			switchToDefaultContent();
		}
	}
}
