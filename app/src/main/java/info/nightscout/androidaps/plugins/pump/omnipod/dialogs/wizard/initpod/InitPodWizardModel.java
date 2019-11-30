/*
 * Copyright 2012 Roman Nurik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.nightscout.androidaps.plugins.pump.omnipod.dialogs.wizard.initpod;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.atech.android.library.wizardpager.model.DisplayTextPage;

import com.tech.freak.wizardpager.model.AbstractWizardModel;
import com.tech.freak.wizardpager.model.PageList;

import info.nightscout.androidaps.R;
import info.nightscout.androidaps.plugins.pump.omnipod.defs.PodInitActionType;
import info.nightscout.androidaps.plugins.pump.omnipod.dialogs.wizard.pages.PodInfoFragment;

/**
 * Created by andy on 12/11/2019
 */
public class InitPodWizardModel extends AbstractWizardModel {
    public InitPodWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(

                new DisplayTextPage(this,
                        R.string.omnipod_init_pod_wizard_step1_title,
                        R.string.omnipod_init_pod_wizard_step1_desc,
                        R.style.WizardPagePodContent).setRequired(true).setCancelReason("None"),

                new InitActionPage(this,
                        R.string.omnipod_init_pod_wizard_step2_title,
                        PodInitActionType.PairAndPrimeWizardStep
                ).setRequired(true).setCancelReason("Cancel"),

                new DisplayTextPage(this,
                        R.string.omnipod_init_pod_wizard_step3_title,
                        R.string.omnipod_init_pod_wizard_step3_desc,
                        R.style.WizardPagePodContent).setRequired(true).setCancelReason("Cancel"),

                new InitActionPage(this,
                        R.string.omnipod_init_pod_wizard_step4_title,
                        PodInitActionType.FillCannulaSetBasalProfileWizardStep
                ).setRequired(true).setCancelReason("Cancel")
        );
    }


    public Fragment getReviewFragment() {
        PodInfoFragment.isInitPod = true;
        return new PodInfoFragment();
    }


}
