import sys

from sys import argv
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.ui import Select

class RequestHandler(object):
    def __init__(self):
        self.browser = webdriver.PhantomJS('phantomjs')
        # self.browser.implicitly_wait(60)
        conf = open('config')
        self.username = file.readline(conf).rstrip('\n')
        self.password = file.readline(conf).rstrip('\n')
        self.lang = "Cpp"
        conf.close()

    def option_select(self, *kargs):
        para_dict = dict()
        for count, thing in enumerate(kargs):
            para_dict[count] = thing

        if para_dict[1] == 's':
            self.submit(para_dict[2], para_dict[3], para_dict[4])
        elif para_dict[1] == 'g':
            self.get_src(para_dict[2], para_dict[3])
        else:
            print "Wrong options\n"


    def get_src(self, src_name, lang):
        self.browser.get("https://oj.leetcode.com/problems")
        self.browser.find_element_by_link_text(src_name).click()
        self.switch_lang(lang)
        src_container = self.browser.find_element_by_class_name('ace_content')
        print src_container.text

    def login(self, username, password):
        self.browser.get('https://oj.leetcode.com/accounts/login')
        self.browser.find_element_by_id('id_login').send_keys(username)
        self.browser.find_element_by_id('id_password').send_keys(password)
        self.browser.find_element_by_xpath("//button[contains(.,'Sign In')]").click()

    def switch_lang(self, lang):
        lang_switcher = Select(self.browser.find_element_by_name('lang'))
        lang_switcher.select_by_visible_text(lang)

    def submit(self, file_name, src_name, lang):
        self.login(self.username, self.password)
        self.browser.find_element_by_link_text(src_name).click()

        #change languange
        self.switch_lang(lang)
        self.lang = lang
        print "set language to %s" %(lang)

        f = open(file_name)
        src_text = file.read(f)
        f.close()

        target = self.browser.find_element_by_class_name('ace_text-input')
        target.send_keys(Keys.SHIFT + Keys.END)
        target.send_keys(Keys.SHIFT + Keys.PAGE_DOWN)
        target.send_keys(Keys.DELETE)
        target.send_keys(src_text)
        if self.lang == "Java":
            target.send_keys(Keys.SHIFT + Keys.END)
            target.send_keys(Keys.SHIFT + Keys.PAGE_DOWN)
            target.send_keys(Keys.DELETE)

        # submit
        submit_button = self.browser.find_element_by_id('button1')
        submit_button.click()

        # check result
        while(
            self.browser.find_element_by_id('result_state').text == 'Pending' or
            self.browser.find_element_by_id('result_state').text == 'Judging'
                ):
            WebDriverWait(self.browser, 60)
            sys.stdout.write('\rjudging...')
            sys.stdout.flush()


        print "\n"
        print self.browser.find_element_by_id('result_state').text
        print self.browser.find_element_by_id('last_executed_testcase_output_row').text
        print self.browser.find_element_by_id('result_code_output').text
        print self.browser.find_element_by_id('wa_output').text


    def shutdown(self):
        self.browser.quit()

if __name__ == '__main__':
   obj = RequestHandler()
   obj.option_select(*argv)
   obj.shutdown()
