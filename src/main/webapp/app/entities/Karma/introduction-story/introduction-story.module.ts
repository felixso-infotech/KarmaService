import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaSharedModule } from 'app/shared';
import {
  IntroductionStoryComponent,
  IntroductionStoryDetailComponent,
  IntroductionStoryUpdateComponent,
  IntroductionStoryDeletePopupComponent,
  IntroductionStoryDeleteDialogComponent,
  introductionStoryRoute,
  introductionStoryPopupRoute
} from './';

const ENTITY_STATES = [...introductionStoryRoute, ...introductionStoryPopupRoute];

@NgModule({
  imports: [KarmaSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    IntroductionStoryComponent,
    IntroductionStoryDetailComponent,
    IntroductionStoryUpdateComponent,
    IntroductionStoryDeleteDialogComponent,
    IntroductionStoryDeletePopupComponent
  ],
  entryComponents: [
    IntroductionStoryComponent,
    IntroductionStoryUpdateComponent,
    IntroductionStoryDeleteDialogComponent,
    IntroductionStoryDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaIntroductionStoryModule {}
