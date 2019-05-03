import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaAppSharedModule } from 'app/shared';
import {
  InstructionVideoComponent,
  InstructionVideoDetailComponent,
  InstructionVideoUpdateComponent,
  InstructionVideoDeletePopupComponent,
  InstructionVideoDeleteDialogComponent,
  instructionVideoRoute,
  instructionVideoPopupRoute
} from './';

const ENTITY_STATES = [...instructionVideoRoute, ...instructionVideoPopupRoute];

@NgModule({
  imports: [KarmaAppSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    InstructionVideoComponent,
    InstructionVideoDetailComponent,
    InstructionVideoUpdateComponent,
    InstructionVideoDeleteDialogComponent,
    InstructionVideoDeletePopupComponent
  ],
  entryComponents: [
    InstructionVideoComponent,
    InstructionVideoUpdateComponent,
    InstructionVideoDeleteDialogComponent,
    InstructionVideoDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaAppInstructionVideoModule {}
